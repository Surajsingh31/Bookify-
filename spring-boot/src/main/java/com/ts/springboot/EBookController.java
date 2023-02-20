package com.ts.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.dao.EbookDAO;
import com.model.EBook;
import java.util.List;

@RestController
public class EBookController {
    @Autowired
    EbookDAO eBookDAO;

    @GetMapping("/getAllEBooks")
    public List<EBook> getAllBooks(){
        return eBookDAO.getAlleBooks();
    }

    @GetMapping("/geteBookById/{bookId}")
    public EBook geteBookById(@PathVariable("eBookId") int eBookId){

        return eBookDAO.geteBookById(eBookId);
    }

    @GetMapping("/geteBookByName/{eBookName}")
    public EBook getBookByName(@PathVariable("eBookName") String eBookName){

        return eBookDAO.geteBookByName(eBookName);
    }

    @GetMapping("getEBooksByGenre/{genre}")
    public List<EBook> getEBooksBasedOnGenre(@PathVariable("genre") String genre){
        return eBookDAO.getEBooksByGenre(genre);
    }
    @GetMapping("getEBooksByPrice/{genre}")
    public List<EBook> getEBooksByPrice(@PathVariable("genre") String genre){
        return eBookDAO.getEBooksByPrice(genre);
    }
    @GetMapping("getEBooksByPriceHigh/{genre}")
    public List<EBook> getEBooksByPriceHigh(@PathVariable("genre") String genre){
        return eBookDAO.getEBooksByPriceHigh(genre);
    }
    @GetMapping("getEBooksByAlphabet/{genre}")
    public List<EBook> getEBooksByAlphabet(@PathVariable("genre") String genre){
        return eBookDAO.getEBooksByAlphabet(genre);
    }
    @GetMapping("getEBooksByAlphabetDesc/{genre}")
    public List<EBook> getEBooksByAlphabetDesc(@PathVariable("genre") String genre){
        return eBookDAO.getEBooksByAlphabetDesc(genre);
    }

    @PostMapping("/registereBook")
    public String registereBook(@RequestBody EBook eBook){

        EBook eBook1 = eBookDAO.registereBook(eBook);

        if(eBook1 != null)
            return "E-Book Registered into the Database";
        return "E-Book registration Failed!!!";

    }

    @PutMapping("/updateeBook")
    public String updateeBook(@RequestBody EBook eBook){

        EBook eBook1 = eBookDAO.registereBook(eBook);

        if(eBook1 != null)
            return "E-Book Updated into the Database";
        return "E-Book Updation Failed!!!";

    }

    @DeleteMapping("/deleteeBookById/{eBookId}")
    public String deleteeBookById(@PathVariable("eBookId") int eBookId){

        eBookDAO.deleteeBookById(eBookId);
        return "E-Book with id: " + eBookId + " deleted Successfully";
        
    }
    
}