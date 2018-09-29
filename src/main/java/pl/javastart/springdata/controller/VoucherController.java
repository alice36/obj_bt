package pl.javastart.springdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.javastart.springdata.repository.VoucherRepository;
import pl.javastart.springdata.model.Client;
import pl.javastart.springdata.model.Ticket;
import pl.javastart.springdata.model.Voucher;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Controller
public class VoucherController {
    VoucherRepository voucherRepository;

    public VoucherController(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    @GetMapping("/")
    public String homeVoucher(Model model) {
        Ticket ticket = new Ticket();
        String username = System.getProperty("user.name");
        ticket.setLogin(username);

        ticket.setTravelDate(LocalDate.now());
        model.addAttribute("allClients", Client.values());
        model.addAttribute("newTicket", ticket);
        return "index";
    }

    @GetMapping("/vshow")
    public String home(Model model) {
        List<Voucher> vouchers = voucherRepository.findAll();
        model.addAttribute("vouchers", vouchers);
        return "vshow";
    }

//    @GetMapping("/readxls")
//    public String readxls() throws FileNotFoundException {
//        BufferedReader reader = null;
//        Voucher voucher = null;
//        Voucher found = null;
//        try {
//            File file = new File("C:/Users/Alice/Desktop/vouchers.csv");
//            reader = new BufferedReader(new FileReader(file));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                found = voucherRepository.findVoucherUsingNumber(line);
//                if (found == null) {
//                    voucher = new Voucher();
//                    voucher.setNumer(line);
//                    voucher.setIsAvailable(1);
//                    voucher.setAddedDate(LocalDate.now());
//                    voucherRepository.save(voucher);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return "redirect:/";
//    }

    @GetMapping("/readxls")
    public String readxls1(){
        return "fileUpload";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file1,
                              RedirectAttributes redirectAttributes){
        BufferedReader reader = null;
        Voucher voucher = null;
        Voucher found = null;
        try {
//          File file = new File("C:/Users/Alice/Desktop/vouchers.csv");
            InputStream is = file1.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is));
//            reader = new BufferedReader(new FileReader(file1.getOriginalFilename()));
            String line;
            while ((line = reader.readLine()) != null) {
                found = voucherRepository.findVoucherUsingNumber(line);
                if (found == null) {
                    voucher = new Voucher();
                    voucher.setNumer(line);
                    voucher.setIsAvailable(1);
                    voucher.setAddedDate(LocalDate.now());
                    voucherRepository.save(voucher);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/";
    }
}
