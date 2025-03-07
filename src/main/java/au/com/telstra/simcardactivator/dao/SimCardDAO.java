package au.com.telstra.simcardactivator.dao;


import au.com.telstra.simcardactivator.model.SimActivationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimCardDAO extends JpaRepository<SimActivationRecord,Long> {
}
