package pl.javastart.springdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.springdata.repository.VoucherRepository;
import pl.javastart.springdata.model.Client;
import pl.javastart.springdata.model.Ticket;
import pl.javastart.springdata.model.Voucher;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class VoucherController {
    VoucherRepository voucherRepository;

    public VoucherController(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    @GetMapping("/indexVoucher")
    public String homeVucher(Model model) {
        Ticket ticket = new Ticket();
        String username = System.getProperty("user.name");
        ticket.setLogin(username);

        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        ticket.setDate(dateFormat.format(new Date()));
        model.addAttribute("allClients", Client.values());
        model.addAttribute("newTicket", ticket);
        return "indexVoucher";

    }

    @GetMapping("/vshow")
    public String home(Model model) {

        List<Voucher> vouchers = voucherRepository.findAll();
        model.addAttribute("vouchers", vouchers);
        return "vshow";

    }
}
