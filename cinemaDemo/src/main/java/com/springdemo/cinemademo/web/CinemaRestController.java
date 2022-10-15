package com.springdemo.cinemademo.web;

import com.springdemo.cinemademo.dao.FilmRepository;
import com.springdemo.cinemademo.dao.TicketRepository;
import com.springdemo.cinemademo.entities.Film;
import com.springdemo.cinemademo.entities.Ticket;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class CinemaRestController {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping("/listFilms")
    public List<Film> films(){
        return filmRepository.findAll();
    }


    @GetMapping(path="imageFilm/{id}",produces = MediaType.IMAGE_JPEG_VALUE)//IMAGE_PNG_VALUE)
    public byte[] image(@PathVariable(name = "id") Long id) throws Exception{
        Film f= filmRepository.findById(id).get();
        String photoName=f.getPhoto();
        File file= new File(System.getProperty("user.home")+"/cinema/images/"+photoName);
        Path path= Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

    @PostMapping("/payerTickets")
    @Transactional
    public List<Ticket> payerTickets(@RequestBody TicketForm ticketForm){
        List<Ticket> listTickets=new ArrayList<>();
        ticketForm.getTickets().forEach(idTicket ->{
            Ticket ticket = ticketRepository.findById(idTicket).get();
            ticket.setNomClient(ticketForm.getNomClient());
            ticket.setCodePayement(ticketForm.getCodePayement());
            ticket.setReserve(true);
            ticketRepository.save(ticket);
            listTickets.add(ticket);
        });

        return listTickets;


    }

}

@Data
class TicketForm{

    private String nomClient;
    private int codePayement;
    private List<Long> tickets= new ArrayList<>();
}