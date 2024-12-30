package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Promo;
import ensa.gestionnotes.projet_jee.dto.PromoDTO;

import java.util.List;

public interface IPromoService {
    public List<PromoDTO> getAllPromos();
    public PromoDTO createPromo(PromoDTO promo);
    public void deletePromo(long id);
    public List<Promo> findLastPromos();

}
