 package org.andou.MCIP.web;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.andou.MCIP.dao.MentionRepository;
import org.andou.MCIP.dao.PersonnelRepository;
import org.andou.MCIP.dao.SuspectRepository;
import org.andou.MCIP.entities.Evenement;
import org.andou.MCIP.entities.Mention;
import org.andou.MCIP.entities.Personnel;
import org.andou.MCIP.entities.Role;
import org.andou.MCIP.entities.Suspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@CrossOrigin("*")
public class MCIPRestController {
	@Autowired
	private MentionRepository mentionRepository;
	
	@GetMapping(path="/listerMentionDate/{dateMention}")
	private List<Mention> listerMentionDate(@PathVariable(name="dateMention") String dateMention) throws ParseException {
		SimpleDateFormat sdt=new SimpleDateFormat("yyyy-MM-dd");
		// DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		List<Mention> reslt= mentionRepository.findByDateMention(sdt.parse(dateMention) );
		return reslt;
	}
	
}
