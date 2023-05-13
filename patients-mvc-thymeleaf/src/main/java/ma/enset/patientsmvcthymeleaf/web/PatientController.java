package ma.enset.patientsmvcthymeleaf.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.enset.patientsmvcthymeleaf.entites.Patient;
import ma.enset.patientsmvcthymeleaf.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Optional;


@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }
    @GetMapping("/delete")
    public String delete(Long id, String keyword, int page){
        patientRepository.deleteById(id);
        return "redirect:/index?keyword="+keyword+"&page="+page;
    }

    @GetMapping(path = "/index")
    public String patients(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "5") int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword){
        Page<Patient> patientsPage = patientRepository.findByNameContains(keyword, PageRequest.of(page,size));
        model.addAttribute("patientsList", patientsPage.getContent());
        model.addAttribute("pages",new int[patientsPage.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword", keyword);
        return "materialize";
    }

    @GetMapping("/addPatient")
    public String addPatient(Model model){
        model.addAttribute("patient", new Patient());
        return "addPatient";
    }

    @GetMapping("/save")
    public String save(@Valid Patient patient, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "addPatient";
        patientRepository.save(patient);
        return "addPatient";
    }

    @GetMapping("/updatePatient")
    public String updatePatient(Model model, Long id, String keyword, int page){
        Patient patient = patientRepository.findById(id).orElse(null);
        model.addAttribute("patient",patient);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        return "updatePatient";
    }

    @GetMapping("/update")
    public String update(Patient patient, String keyword, int page){
        patientRepository.save(patient);
        return "redirect:/index?keyword="+keyword+"&page="+page;
    }

}
