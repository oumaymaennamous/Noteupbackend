package ensa.gestionnotes.projet_jee.service;
import ensa.gestionnotes.projet_jee.Entity.Filiere;
import ensa.gestionnotes.projet_jee.Entity.Module;
import ensa.gestionnotes.projet_jee.Entity.Semestre;
import ensa.gestionnotes.projet_jee.dto.ModuleDTO;
import ensa.gestionnotes.projet_jee.repository.FiliereRepository;
import ensa.gestionnotes.projet_jee.repository.ModuleRepository;
import ensa.gestionnotes.projet_jee.repository.SemestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ImpModuleService implements IModuleService{
    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private FiliereRepository filiereRepository;
    @Autowired
    private SemestreRepository semestreRepository;

    public List<ModuleDTO> getAllModules() {
        List<Module> modules = moduleRepository.findAll();
        return modules.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ModuleDTO convertToDTO(Module module) {
        ModuleDTO dto = new ModuleDTO();
        dto.setCodeModule(module.getCodeModule());
        dto.setNameModule(module.getNameModule());
        dto.setFiliereName(module.getFiliere().getNomFiliere());
        dto.setSemestreName(module.getSemestre().getSemestre());
        dto.setAnnee(module.getSemestre().getAnnee());
        return dto;
    }

    @Override
    public ModuleDTO addModule(ModuleDTO moduleDTO) {
        Filiere filiere = filiereRepository.findByNomFiliere(moduleDTO.getFiliereName());


        // Trouver le Semestre correspondant
        Semestre semestre = semestreRepository.findByNomAndAnnee(moduleDTO.getSemestreName(), moduleDTO.getAnnee())
                .orElseThrow(() -> new RuntimeException("Semestre non trouvé"));

        // Créer une nouvelle entité Module
        Module module = new Module();
        module.setNameModule(moduleDTO.getNameModule());
        module.setFiliere(filiere);
        module.setSemestre(semestre);

        // Sauvegarder le Module dans la base de données
        moduleRepository.save(module);

       return convertToDTO(module);

    }

    @Override
    public ModuleDTO getModuleById(long id) {
        Module module=moduleRepository.findById(id).orElseThrow(()-> new RuntimeException("Module not found"));
        return convertToDTO(module);
    }
}
