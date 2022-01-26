package com.tiago.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.os.domain.Cliente;
import com.tiago.os.domain.OS;
import com.tiago.os.domain.Tecnico;
import com.tiago.os.domain.enuns.Prioridade;
import com.tiago.os.domain.enuns.Status;
import com.tiago.os.repositories.ClienteRepository;
import com.tiago.os.repositories.OSRepository;
import com.tiago.os.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository osRepository;
	
	public void instanciaDB() {
		
		Tecnico t1 = new Tecnico(null, "Tiago Olveira", "922.059.720-90", "(75) 99842-1356");
		Tecnico t2 = new Tecnico(null, "Linus Torvalds", "641.760.040-88", "(88) 94545-4545");
		Tecnico t3 = new Tecnico(null, "Alan Turing", "332.040.820-83", "(88) 96535-4565");
		Tecnico t4 = new Tecnico(null, "Richard Stallman", "756.192.280-96", "(88) 94444-4545");
		Tecnico t5 = new Tecnico(null, "Tim Berners-Lee", "926.076.200-66", "(88) 94545-4545");
		
		
		Cliente c1 = new Cliente(null, "Betina Campos", "834.920.150-93", "(75) 99844-8888");
		
		OS os1 = new OS(null, Prioridade.ALTA, "Troca fonte do Notebook", Status.ANDAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}
}
