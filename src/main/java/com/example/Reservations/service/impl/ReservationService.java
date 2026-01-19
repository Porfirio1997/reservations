package com.example.Reservations.service.impl;

import com.example.Reservations.dto.ReservationDTO;
import com.example.Reservations.exception.BusinessException;
import com.example.Reservations.exception.NotFoundException;
import com.example.Reservations.mapper.ReservationDTOMapper;
import com.example.Reservations.model.entity.Location;
import com.example.Reservations.model.entity.Reservation;
import com.example.Reservations.model.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationService {

    private final ReservationRepository repository;
    private final ClientLocationReservationService domainService;

    public Long save(ReservationDTO dto) {
        Reservation reservation = ReservationDTOMapper.toDomain(dto);



        var client  = domainService.findClientById(dto.clientId());
        reservation.setClient(client);

        var location = domainService.findLocationById(dto.locationId());
        reservation.setLocation(location);


        validateReservationDuration(reservation);

        if (repository.existsByLocationAndDataInicioLessThanAndDataFimGreaterThan(location,dto.dataFim(),dto.dataInicio()))
            throw new BusinessException("Localização está reservada para a data","business.location.is.reserved");
        return repository.save(reservation).getId();
    }

    public Reservation findById(Long id) {
        Reservation reservation = repository.findById(id).orElseThrow(() -> new NotFoundException("Reserva não encontrada", "database.client.not.found"));;
        return reservation;
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public List<ReservationDTO> getAllReservations() {
        return repository.findAll()
                .stream()
                .map(ReservationDTOMapper::toResponse)
                .toList();
    }


    public void validateReservationDuration(Reservation reservation) {
        Location location = reservation.getLocation();
        Instant dataInicio = reservation.getDataInicio();
        Instant dataFim = reservation.getDataFim();
        if (dataInicio == null || dataFim == null) {
            throw new IllegalArgumentException("Data de início e fim devem ser informadas");
        }
        Duration duracao = Duration.between(dataInicio, dataFim);
        Duration tempoMinimo = Duration.between(Instant.EPOCH, location.getTempo_minimo());
        Duration tempoMaximo = Duration.between(Instant.EPOCH, location.getTempo_maximo());
        if (duracao.compareTo(tempoMinimo) < 0) {
            throw new IllegalArgumentException(
                    "A reserva é menor que o tempo mínimo permitido para esta localização: "
                            + tempoMinimo.toMinutes() + " minutos"
            );
        }
        if (duracao.compareTo(tempoMaximo) > 0) {
            throw new IllegalArgumentException(
                    "A reserva excede o tempo máximo permitido para esta localização: "
                            + tempoMaximo.toMinutes() + " minutos"
            );
        }
    }

}
