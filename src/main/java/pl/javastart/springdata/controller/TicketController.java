package pl.javastart.springdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.javastart.springdata.model.Voucher;
import pl.javastart.springdata.repository.TicketRepository;
import pl.javastart.springdata.model.Ticket;
import pl.javastart.springdata.repository.VoucherRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Controller
public class TicketController {

    TicketRepository ticketRepository;
    VoucherRepository voucherRepository;

    public TicketController(TicketRepository ticketRepository, VoucherRepository voucherRepository) {
        this.ticketRepository = ticketRepository;
        this.voucherRepository = voucherRepository;
    }

    @GetMapping("/tshow")
    public String home2(Model model) {
        String username = System.getProperty("user.name");
        List<Ticket> tickets = ticketRepository.findTicketUsingLogin(username);
        model.addAttribute("tickets", tickets);
        return "tshow";
    }

    @PostMapping("/generated")
    public String ticketiing(Ticket ticket, Model model) {
//        Optional<Voucher> freeVoucher = voucherRepository.findFirstFreeVoucher();
        Voucher freeVoucher = voucherRepository.findFirstFreeVoucher();
        long counter=0;
        if (freeVoucher!=null) {
            if (ticket.getClientName()==null || ticket.getFromPlace().equals("") || ticket.getToPlace().equals("") || ticket.getPerson().equals("")) {
                return "errorHt";
            } else {
                counter = ticketRepository.countTicketUsingLoginAndDate(System.getProperty("user.name"));
                if (counter<5) {
                    ticket.setVoucher(freeVoucher);
                    freeVoucher.setIsAvailable(0);
                    ticket.setBookingDate(LocalDate.now());
                    ticketRepository.save(ticket);

                    Ticket tickets = ticketRepository.findTicketUsingNumer(ticket.getVoucher().getNumer());
                    model.addAttribute("tickets", tickets);
                    return "tshow";
                }
                else {
                    return "errorNumber";
                }
            }
        } else {
            return "lack";
        }
    }

    @GetMapping("/csv")
    public String csv() throws IOException {
        List<Ticket> tickets = ticketRepository.findAll();
        String home = System.getProperty("user.home");

        FileWriter fileWriter = new FileWriter(home + "/Downloads/" + "fileBT.csv");
        BufferedWriter bfw = new BufferedWriter(fileWriter);
        bfw.write("id;voucher_id;voucher_number;login;person;travel_date;from;to;client;book_date;commentary");
        bfw.newLine();

        for (Ticket ticket : tickets) {
            bfw.write(ticket.toString());
            bfw.newLine();
        }

        bfw.close();
        return "redirect:/";
    }
}
