package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.Entity.BoardPost;
import Industryacademic.project.backend.repository.BoardPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    BoardPostRepository BP;

    public BoardPost save(BoardPost board) {
        return BP.save(board);
    }


}
