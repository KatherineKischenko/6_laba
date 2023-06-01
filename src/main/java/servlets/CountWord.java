package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

@WebServlet(name = "CountWord", value = "/counter")
public class CountWord extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/counter.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s1 = new String(Files.readAllBytes(FileSystems.getDefault().getPath("C:\\Program Files (x86)\\Проект\\УНИК\\ООП\\Kate Kish\\src\\main\\webapp\\text\\text.txt"))).toLowerCase();
        req.setCharacterEncoding("UTF-8");
        String word = req.getParameter("wordForSearch").toLowerCase();

        System.out.println(word);

        int index = s1.indexOf(word);
        int countWord = 0;

        while (index >= 0)
        {
            countWord = countWord+ 1;
            System.out.println(index);
            index= s1.indexOf(word, index+1);
        }

        System.out.println(countWord);
        req.setAttribute("count", countWord);
        req.setAttribute("searchWord", word);
        doGet(req, resp);
    }
}
