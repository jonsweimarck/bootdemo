package se.scatteredbits.springboot.subjectlog.queryobject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectLogQueryObjectRepository extends JpaRepository<SubjectLogQueryObject, String> {
}
