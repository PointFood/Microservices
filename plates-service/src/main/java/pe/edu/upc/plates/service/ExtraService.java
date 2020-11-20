package pe.edu.upc.plates.service;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.plates.entity.Extra;

import java.util.List;

public interface ExtraService {

    Extra createExtra(Extra extra);
    Extra getExtraById(Long id);
    Extra updateExtra(Long id, Extra extra);
    ResponseEntity<?> deleteExtra(Long id);
    List<Extra> getExtrasByRestaurant(Long id);
}
