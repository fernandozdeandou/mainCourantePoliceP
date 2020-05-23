package org.andou.MCIP.services;

import org.andou.MCIP.Metier.RequerentMetier;
import org.andou.MCIP.entities.Requrent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class RequerentRestService {
	@Autowired
	private RequerentMetier requerentMetier;
    @GetMapping(path="/detailRequerent/{idRequerent}")
	public Requrent detailRequerent(@PathVariable Long idRequerent) {
		return requerentMetier.detailRequerent(idRequerent);
	}
	@PostMapping(path="/requrents")
	public Requrent saveRequent(@RequestBody Requrent req) {
		return requerentMetier.saveRequent(req);
	}
	@GetMapping(path="/requrents")
	public Page<Requrent> listeRequerent(@RequestParam(name="page")int page, @RequestParam(name="size")int size) {
		return requerentMetier.listeRequerent(page, size);
	}

}
