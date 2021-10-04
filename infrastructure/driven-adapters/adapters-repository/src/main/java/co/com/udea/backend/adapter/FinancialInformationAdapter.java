package co.com.udea.backend.adapter;

import co.com.udea.backend.model.entities.FinancialInformation;
import co.com.udea.backend.model.gateway.FinancialInformationGateway;
import co.com.udea.backend.mysql.dtos.FinancialInformationData;
import co.com.udea.backend.mysql.repository.FinancialInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class FinancialInformationAdapter implements FinancialInformationGateway {

    private final FinancialInformationRepository financialInformationRepository;

    @Override
    public Mono<FinancialInformation> createFinancialInformation(FinancialInformation financialInformation) {
        FinancialInformationData data = mapperDtoToData(financialInformation);
        return Mono.just(financialInformationRepository.save(data))
                .flatMap(financialInfo -> mapperDataToDto(data));
    }

    @Override
    public Mono<FinancialInformation> updateFinancialInformation(FinancialInformation financialInformation) {
        return Mono.just(financialInformationRepository.findById(financialInformation.getUserId()).get())
                .flatMap(infoData -> setInformacion(financialInformation, infoData))
                .flatMap(infoUpdate -> Mono.just(financialInformationRepository.save(infoUpdate)))
                .thenReturn(financialInformation);
    }

    @Override
    public Mono<FinancialInformation> getFinancialInformationById(Integer id) {
        return Mono.just(financialInformationRepository.findById(id).orElse(new FinancialInformationData()))
                .flatMap(this::mapperDataToDto);
    }

    private Mono<FinancialInformationData> setInformacion(FinancialInformation dto, FinancialInformationData data){
        data.setIncome(dto.getIncome());
        data.setConsuption(dto.getConsuption());
        data.setBankconsignements(dto.getBankConsignements());
        data.setAssetsvalue(dto.getAssetsValue());
        data.setLiabilitiesvalue(dto.getLiabilitiesValue());
        return Mono.just(data);
    }

    private FinancialInformationData mapperDtoToData(FinancialInformation financialInformation){
        FinancialInformationData data = new FinancialInformationData();
        data.setUser_id(financialInformation.getUserId());
        data.setIncome(financialInformation.getIncome());
        data.setConsuption(financialInformation.getConsuption());
        data.setBankconsignements(financialInformation.getBankConsignements());
        data.setAssetsvalue(financialInformation.getAssetsValue());
        data.setLiabilitiesvalue(financialInformation.getLiabilitiesValue());
        return data;
    }

    private Mono<FinancialInformation> mapperDataToDto(FinancialInformationData financialInformationData){
        return Mono.just(FinancialInformation.builder()
                .userId(financialInformationData.getUser_id())
                .income(financialInformationData.getIncome())
                .consuption(financialInformationData.getConsuption())
                .bankConsignements(financialInformationData.getBankconsignements())
                .assetsValue(financialInformationData.getAssetsvalue())
                .liabilitiesValue(financialInformationData.getLiabilitiesvalue())
                .build());
    }
}
