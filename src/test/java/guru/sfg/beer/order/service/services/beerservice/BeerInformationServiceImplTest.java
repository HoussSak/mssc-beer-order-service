package guru.sfg.beer.order.service.services.beerservice;

import guru.sfg.beer.order.service.bootstrap.BeerOrderBootStrap;
import guru.sfg.beer.order.service.services.beerservice.model.BeerDto;
import guru.sfg.beer.order.service.web.model.BeerOrderLineDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Disabled
class BeerInformationServiceImplTest {
    @Autowired
    BeerInformationService beerInformationService;

    @Test
    void getBeerInformation() {
        Optional<BeerDto>  result = beerInformationService.getBeerById(BeerOrderBootStrap.BEER_1_UUID);
        System.out.println(result);
    }
}