package org.andou.MCIP.services;

import org.andou.MCIP.Metier.RequerentMetier;
import org.andou.MCIP.entities.Requrent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/mcip/requerent")
public class RequerentRestService {
	@Autowired
	private RequerentMetier requerentMetier;
	
	@PreAuthorize("hasRole('USER') or hasRole('CHEF') or hasRole('ADMIN') or hasRole('SMCIP')")
    @GetMapping(path="/detailRequerent/{idRequerent}")
	public Requrent detailRequerent(@PathVariable Long idRequerent) {
		return requerentMetier.detailRequerent(idRequerent);
	}
	@PostMapping(path="/requrents")
	@PreAuthorize("hasRole('SMCIP')")
	public Requrent saveRequent(@RequestBody Requrent req) {
		return requerentMetier.saveRequent(req);
	}
	@GetMapping(path="/requrents")
	@PreAuthorize("hasRole('USER') or hasRole('CHEF') or hasRole('ADMIN') or hasRole('SMCIP')")
	public Page<Requrent> listeRequerent(@RequestParam(name="page")int page, @RequestParam(name="size")int size) {
		return requerentMetier.listeRequerent(page, size);
	}

}
