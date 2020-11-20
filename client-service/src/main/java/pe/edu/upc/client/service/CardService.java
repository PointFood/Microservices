package pe.edu.upc.client.service;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.client.entity.Card;

import java.util.List;

public interface CardService {

    Card createCard(Card card);
    Card getCardById(Long id);
    Card updateCard(Long id, Card card);
    ResponseEntity<?> deleteCard(Long id);
    List<Card> getCardsByClient(Long id);
}
