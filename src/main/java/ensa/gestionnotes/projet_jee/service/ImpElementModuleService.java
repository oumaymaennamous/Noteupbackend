package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Element_Module;
import ensa.gestionnotes.projet_jee.Entity.Mode_Evaluation;
import ensa.gestionnotes.projet_jee.Entity.Module;
import ensa.gestionnotes.projet_jee.Entity.Professeur;
import ensa.gestionnotes.projet_jee.dto.ElementModuleDTO;
import ensa.gestionnotes.projet_jee.dto.ModeEvaluationDTO;
import ensa.gestionnotes.projet_jee.repository.ElementModuleRepository;
import ensa.gestionnotes.projet_jee.repository.ModeEvaluationRepository;
import ensa.gestionnotes.projet_jee.repository.ModuleRepository;
import ensa.gestionnotes.projet_jee.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImpElementModuleService implements IElementModuleService{
    @Autowired
    private  ElementModuleRepository elementModuleRepository;
    @Autowired
    private  ModuleRepository moduleRepository;
    @Autowired
    private  ProfesseurRepository professeurRepository;
    @Autowired
    private  ModeEvaluationRepository modeEvaluationRepository;
    @Override
    public List<ElementModuleDTO> getElementsByModuleId(Long moduleId) {
        return elementModuleRepository.findByModuleCodeModule(moduleId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public ElementModuleDTO createElement(Long moduleId, ElementModuleDTO elementDTO) {
        Module module = moduleRepository.findById(moduleId).orElse(null);

        Professeur professeur = professeurRepository.findById(elementDTO.getProfessorId()).orElse(null);


        Element_Module element = new Element_Module();
        element.setNameElementModule(elementDTO.getName());
        element.setCoefficient(elementDTO.getCoefficient());
        element.setModule(module);
        element.setProfesseur(professeur);
        element.setActive(true);

        return convertToDTO(elementModuleRepository.save(element));
    }

    @Override
    public void deleteElement(Long elementId) {
        elementModuleRepository.deleteById(elementId);
    }

    @Override
    public ModeEvaluationDTO addEvaluationMode(Long elementId, ModeEvaluationDTO evaluationDTO) {
        Element_Module element = elementModuleRepository.findById(elementId).orElse(null);

        Mode_Evaluation mode = new Mode_Evaluation();
        mode.setType(evaluationDTO.getType());
        mode.setCoefficient(evaluationDTO.getCoefficient());
        mode.setElementModule(element);

        return convertToDTO(modeEvaluationRepository.save(mode));
    }

    @Override
    public ModeEvaluationDTO updateEvaluationMode(Long evaluationId, ModeEvaluationDTO evaluationDTO) {
        Mode_Evaluation mode = modeEvaluationRepository.findById(evaluationId).orElse(null);

        mode.setType(evaluationDTO.getType());
        mode.setCoefficient(evaluationDTO.getCoefficient());

        return convertToDTO(modeEvaluationRepository.save(mode));
    }

    @Override
    public void deleteEvaluationMode(Long evaluationId) {
        modeEvaluationRepository.deleteById(evaluationId);
    }

    @Override
    public ElementModuleDTO convertToDTO(Element_Module element) {
        ElementModuleDTO dto = new ElementModuleDTO();
        dto.setId(element.getCodeElementModule());
        dto.setName(element.getNameElementModule());
        dto.setCoefficient(element.getCoefficient());
        dto.setProfessorId(element.getProfesseur().getId());
        dto.setProfessorName(element.getProfesseur().getNom());
        dto.setActive(element.isActive());
        if(element.getModeEvaluations() != null){
         dto.setEvaluationModes(element.getModeEvaluations().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList()));
        }

        return dto;
    }

    @Override
    public ModeEvaluationDTO convertToDTO(Mode_Evaluation mode) {
        ModeEvaluationDTO dto = new ModeEvaluationDTO();
        dto.setCodeMode(mode.getCodeMode());
        dto.setType(mode.getType());
        dto.setCoefficient(mode.getCoefficient());
        return dto;
    }

    @Override
    public List<ElementModuleDTO> getElementModulesByProfessor(String cin) {
        return elementModuleRepository.findElementByProfesseeur(cin)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

}
