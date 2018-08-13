package pl.javastart.springdata;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CommunityController {

    CommunityRepository communityRepository;
    FlatRepository flatRepository;
    ResidentRepository residentRepository;

    public CommunityController(CommunityRepository communityRepository, FlatRepository flatRepository, ResidentRepository residentRepository) {
        this.communityRepository = communityRepository;
        this.flatRepository = flatRepository;
        this.residentRepository = residentRepository;
    }

    @GetMapping("/")
    public String home(Model model) {

        List<Community> communities = communityRepository.findAll();
        List<Flat> flats = flatRepository.findAll();
        List<Resident> residents = residentRepository.findAll();

        model.addAttribute("communities", communities);
        model.addAttribute("flats", flats);
        model.addAttribute("residents", residents);
        return "index";

    }

    @GetMapping("/commadd")
    public String commAdd(Model model) {

        List<Community> communities = communityRepository.findAll();

        model.addAttribute("communities", communities);
        model.addAttribute("newCommunity", new Community());

        return "commadd";

    }
    @PostMapping("/addcommunity")
    public String addFlat(Community community) {

        if (community.getName().equals("")){
            community.setName(community.getAddress());
        }
        communityRepository.save(community);

        return "redirect:/commadd";

    }
    @GetMapping("/commdetails")
    public String commList(Model model, @RequestParam String name) {

        Community community = communityRepository.findByName(name);
        List<Flat> flats = community.getFlats();

        double areaSum = 0;

        for (Flat flat : flats) {
            areaSum=areaSum+flat.getArea();
        }
        model.addAttribute("areaSum", areaSum);
        model.addAttribute("flats", flats);
        model.addAttribute("community", community);

        return "commdetails";

    }

    @GetMapping("/createlist")
    public String modify(Model model,  @RequestParam String with){
        if (with.equals("wspolnota")){
            model.addAttribute("objects", communityRepository.findAll());
        } else if (with.equals("mieszkanie")){
            model.addAttribute("objects", flatRepository.findAll());
        } else if (with.equals("mieszkaniec")){
            model.addAttribute("objects", residentRepository.findAll());
        }
        model.addAttribute("with", with);
        return "index";
    }

    @GetMapping("/modify")
    public String modify(Model model, @RequestParam Long id, @RequestParam String with, @RequestParam String what){
       if (with.equals("wspolnota") && what.equals("edytuj")){
           Community community = communityRepository.findCommunityUsingId(id);
           model.addAttribute("modifyCommunity", community);
           return "editCommunity";
       } else if (with.equals("wspolnota") && what.equals("usuń")){
           Community community = communityRepository.findCommunityUsingId(id);
           boolean check = false;
           List<Flat> flats = flatRepository.findAll();

           for (Flat flat : flats) {
               if (flat.getCommunity().getId().equals(community.getId())){
                   check=true;
                   break;
               }
           }
           if (!check){
               communityRepository.delete(community);
           } else {
               System.out.println("Nie mozna usunac wspolnoty!");
               return "error";
           }
           return "redirect:/";

       } else if (with.equals("mieszkanie") && what.equals("edytuj")) {
           Flat flat = flatRepository.findFlatUsingId(id);
           model.addAttribute("modifyFlat", flat);
           return "editFlat";
       } else if (with.equals("mieszkanie") && what.equals("usuń")){
           Flat flat = flatRepository.findFlatUsingId(id);
           boolean check = false;
           List<Resident> residents = residentRepository.findAll();

           for (Resident resident : residents) {
               if (resident.getFlat().getId().equals(flat.getId())){
                   check=true;
                   break;
               }
           }
           if (!check){
               flatRepository.delete(flat);
           } else {
               System.out.println("Nie mozna usunac mieszkania!");
               return "error";
           }

           return "redirect:/";
       } else if (with.equals("mieszkaniec") && what.equals("edytuj")) {
           Resident resident = residentRepository.findResidentUsingId(id);
           model.addAttribute("modifyResident", resident);
           return "editResident";
       } else if (with.equals("mieszkaniec") && what.equals("usuń")){
           Resident resident = residentRepository.findResidentUsingId(id);
           residentRepository.delete(resident);
           return "redirect:/";
       }

       return "redirect:";
    }

    @PostMapping("/modifycommunity")
    public String saveCommunity(Community community){
       communityRepository.save(community);

        return "redirect:";
    }

    @PostMapping("/modifyflat")
    public String saveFlat(Flat flat){
        Flat flatExisting = flatRepository.findFlatUsingId(flat.getId());
        flat.setCommunity(flatExisting.getCommunity());
        flatRepository.save(flat);

        return "redirect:";
    }

    @PostMapping("/modifyresident")
    public String saveResident(Resident resident){
        Resident residentExisting = residentRepository.findResidentUsingId(resident.getId());
        resident.setFlat(residentExisting.getFlat());
        residentRepository.save(resident);

        return "redirect:";
    }
}
