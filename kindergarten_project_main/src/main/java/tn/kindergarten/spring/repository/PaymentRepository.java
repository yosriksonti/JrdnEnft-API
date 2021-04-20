package tn.kindergarten.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.spring.entities.Payment;
@Repository
public interface PaymentRepository  extends CrudRepository<Payment, Integer>
{

}
