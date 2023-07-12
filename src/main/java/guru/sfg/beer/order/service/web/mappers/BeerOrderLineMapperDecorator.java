package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrderLine;
import guru.sfg.beer.order.service.services.beerservice.BeerInformationService;
import guru.sfg.beer.order.service.services.beerservice.model.BeerDto;
import guru.sfg.beer.order.service.web.model.BeerOrderLineDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;


public abstract class BeerOrderLineMapperDecorator implements BeerOrderLineMapper {
    @Autowired
    private BeerInformationService beerInformationService;

    private BeerOrderLineMapper beerOrderLineMapper;

    public void setBeerInformationService(BeerInformationService beerInformationService) {
        this.beerInformationService = beerInformationService;
    }
    @Autowired
    @Qualifier("delegate")
    public void setBeerOrderLineMapper(BeerOrderLineMapper beerOrderLineMapper) {
        this.beerOrderLineMapper = beerOrderLineMapper;
    }

    @Override
    public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line) {
         BeerOrderLineDto beerOrderLineDto = beerOrderLineMapper.beerOrderLineToDto(line);
         Optional<BeerDto> beerById = beerInformationService.getBeerById(line.getBeerId());
         beerById.ifPresent(beerDto -> {
             beerOrderLineDto.setBeerName(beerDto.getBeerName());
             beerOrderLineDto.setBeerStyle(beerDto.getBeerStyle());
             beerOrderLineDto.setPrice(beerDto.getPrice());
             beerOrderLineDto.setId(beerDto.getId());
         });
        return beerOrderLineDto;
    }

  // public BeerOrderLineDto beerOrderLineToDtoWithInformation(BeerOrderLine line) {
  //     BeerOrderLineDto beerOrderLineDto = beerOrderLineMapper.beerOrderLineToDto(line);
  //     BeerOrderLineDto beerInformation = beerInformationService.getBeerInformation(line.getBeerId());
  //     beerOrderLineDto.setBeerName(beerInformation.getBeerName());
  //     return beerOrderLineDto;
  // }

    @Override
    public BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto) {
        return beerOrderLineMapper.dtoToBeerOrderLine(dto);
    }
}
