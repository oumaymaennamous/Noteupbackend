package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Module;
import ensa.gestionnotes.projet_jee.dto.ModuleDTO;

import java.util.List;

public interface IModuleService {
    public List<ModuleDTO> getAllModules();
    public ModuleDTO convertToDTO(Module module);
    public ModuleDTO addModule(ModuleDTO moduleDTO);
    public ModuleDTO getModuleById(long id);
}
