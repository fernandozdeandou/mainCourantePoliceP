package org.andou.MCIP.Metier;

import org.andou.MCIP.entities.Requrent;
import org.springframework.data.domain.Page;

public interface RequerentMetier {
	public Requrent saveRequent(Requrent req);
	public Page<Requrent> listeRequerent(int page, int size);
	public Requrent detailRequerent(Long idRequerent);
}
