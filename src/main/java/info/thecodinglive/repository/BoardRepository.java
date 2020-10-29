package info.thecodinglive.repository;

import java.util.Optional;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import info.thecodinglive.model.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer>{

}
