package guru.sfg.beer.order.service.services.beerservice;


import guru.sfg.beer.order.service.services.beerservice.model.BeerDto;
import guru.sfg.beer.order.service.web.model.BeerOrderLineDto;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerInformationService {
    Optional<BeerDto> getBeerById(UUID id);
    Optional<BeerDto> getBeerByUpc(String upc);
}
