package org.andou.MCIP.Metier;

import org.andou.MCIP.dao.RequerentRepository;
import org.andou.MCIP.entities.Requrent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ReuerentMetierImpl implements RequerentMetier{
	@Autowired
	private RequerentRepository requerentRepository;

	@Override
	public Requrent saveRequent(Requrent req) {
		// TODO Auto-generated method stub
		return requerentRepository.save(req);
	}

	@Override
	public Page<Requrent> listeRequerent(int page, int size) {
			Pageable pageable = PageRequest.of(page, size, Sort.by("idRequerent").descending());
		return  requerentRepository.findAll(pageable);
	}

	@Override
	public Requrent detailRequerent(Long idRequerent) {
		// TODO Auto-generated method stub
		return requerentRepository.findByIdRequerent(idRequerent);
	}

}
