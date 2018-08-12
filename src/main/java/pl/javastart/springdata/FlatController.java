package pl.javastart.springdata;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FlatController {
    FlatRepository flatRepository;
    CommunityRepository communityRepository;
    ResidentRepository residentRepository;

    public FlatController(FlatRepository flatRepository, CommunityRepository communityRepository, ResidentRepository residentRepository) {
        this.flatRepository = flatRepository;
        this.communityRepository = communityRepository;
        this.residentRepository = residentRepository;
    }

    @GetMapping("/flatlist")
    public String home(Model model) {

        List<Flat> flats = flatRepository.findAll();
        List<Community> communities = communityRepository.findAll();
        model.addAttribute("flats", flats);
        model.addAttribute("newFlat", new Flat());
        model.addAttribute("communities", communities);

        return "flatlist";

    }
    @PostMapping("/addflat")
    public String addFlat(Flat flat) {

        flatRepository.save(flat);

        return "redirect:/flatlist";

    }
    @GetMapping("/flatdetails")
    public String flatDetails(Model model, @RequestParam Long id) {
        Flat flat = flatRepository.findFlatUsingId(id);
        List<Resident> residents = flat.getResidents();

        model.addAttribute("flat", flat);
        model.addAttribute("residents", residents);

        return "flatdetails";

    }

    @GetMapping("/addpersontoflat")
    public String addperson(Model model, @RequestParam Long residentId, @RequestParam Long flatId){
        Resident resident = residentRepository.findResidentUsingId(residentId);
        Flat flat = flatRepository.findFlatUsingId(flatId);

        resident.setFlat(flat);
        residentRepository.save(resident);

        return "redirect:/flatdetails?id=" + flat.getId();
    }

}
