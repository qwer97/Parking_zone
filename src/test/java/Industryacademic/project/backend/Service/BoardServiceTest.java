package Industryacademic.project.backend.Service;

import Industryacademic.project.backend.BackendApplication;
import Industryacademic.project.backend.Entity.BoardPost;
import Industryacademic.project.backend.Entity.MEMBER;
import Industryacademic.project.backend.repository.BoardPostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = BackendApplication.class)
public class BoardServiceTest {

    @Autowired
    private BoardService bs;

    @Autowired
    private BoardPostRepository BP;

    @Test
    public void testBoard(){
        int mno = 2019125003;
        String ti = "개추";
        String con = "앙 기모띠";

        BoardPost b = new BoardPost();
        MEMBER m =new MEMBER();
        m.setMno(mno);
        b.setMember(m);
        b.setTitle(ti);
        b.setContent(con);

        bs.RegistPost(mno,ti,con);

    }

    @Test
    public void delete(){
        int mno = 2019125003;
        int postid=1;

        BoardPost b = new BoardPost();
        MEMBER m =new MEMBER();
        m.setMno(mno);
        b.setMember(m);
        b.setPostid(postid);

        bs.DeletePost(postid,mno);
    }

    @Test
    public void viewTest(){
        List<BoardPost> bl =bs.Viewall();

        for (BoardPost post : bl) {
            System.out.println("글번호: " + post.getPostid());
            System.out.println("Title: " + post.getTitle());
            System.out.println("Content: " + post.getContent());
            System.out.println("작성 시간: "+ post.getCreated());

            // 줄 구분을 위해 빈 줄 출력
            System.out.println();
        }
    }
}
