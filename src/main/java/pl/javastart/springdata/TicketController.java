package pl.javastart.springdata;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

public class TicketController {
    TicketRepository ticketRepository;
    VoucherRepository voucherRepository;

    public TicketController(TicketRepository ticketRepository, VoucherRepository voucherRepository) {
        this.ticketRepository = ticketRepository;
        this.voucherRepository = voucherRepository;
    }

    @GetMapping("/tAdding")
    public String home(Model model) {
        Ticket ticket = new Ticket();
        String username = System.getProperty("user.name");
        ticket.setLogin(username);
        model.addAttribute("newTicket", ticket);
        return "tAdd";
    }

    @GetMapping("/tshow")
    public String home2(Model model) {
        List<Ticket> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);
        return "tshow";
    }

    @PostMapping("/generated")
    public String ticketiing(Ticket ticket, Model model) {
        ticketRepository.save(ticket);
        model.addAttribute("ticketed", ticket);
        return "tGenerated";
    }
}
