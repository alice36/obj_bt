package pl.javastart.springdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.javastart.springdata.model.Voucher;
import pl.javastart.springdata.repository.TicketRepository;
import pl.javastart.springdata.model.Ticket;
import pl.javastart.springdata.repository.VoucherRepository;

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
        List<Ticket> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);
        return "tshow";
    }

    @PostMapping("/generated")
    public String ticketiing(Ticket ticket, Model model) {
//        Optional<Voucher> freeVoucher = voucherRepository.findFirstFreeVoucher();
        Voucher freeVoucher = voucherRepository.findFirstFreeVoucher();

        if (freeVoucher!=null) {
            if (ticket.getClientName()==null || ticket.getFromPlace().equals("") || ticket.getToPlace().equals("") || ticket.getPerson().equals("")) {
                return "errorHt";
            } else {
                ticket.setVoucher(freeVoucher);
                freeVoucher.setIsAvailable(0);
                ticketRepository.save(ticket);

                Ticket tickets = ticketRepository.findTicketUsingId(ticket.getVoucher().getId());
                model.addAttribute("tickets", tickets);
                return "redirect:/tshow";
            }
        } else {
            return "lack";
        }
    }
}
