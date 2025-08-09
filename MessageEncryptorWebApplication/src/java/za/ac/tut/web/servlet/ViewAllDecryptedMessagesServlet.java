package za.ac.tut.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.ejb.bl.EncryptedmesaagesFacadeLocal;
import za.ac.tut.ejb.model.Encryptedmesaages;

public class ViewAllDecryptedMessagesServlet extends HttpServlet {

    @EJB 
    private EncryptedmesaagesFacadeLocal emfl;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        List<Encryptedmesaages> encryptedMessages = emfl.findAll();
        List<String> decryptedMessages = decryptMessages(encryptedMessages);
        
        session.setAttribute("decryptedMessageList", decryptedMessages);
        request.getRequestDispatcher("view_all_decrypted_messages_outcome.jsp").forward(request, response);
    }
    
    private List<String> decryptMessages(List<Encryptedmesaages> encryptedMessages) {
        List<String> decryptedMessages = new ArrayList<>();
        
        for (Encryptedmesaages message : encryptedMessages) {
            String decryptedText = decrypt(message.getCyphertext());
            decryptedMessages.add(decryptedText);
        }
        
        return decryptedMessages;
    }
    
    private String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();

        for (char currentChar : ciphertext.toLowerCase().toCharArray()) {
            if (Character.isLetter(currentChar)) {
                char base = 'a'; 
                char decryptedChar = (char)(((currentChar - base - 3 + 26) % 26) + base);
                plaintext.append(decryptedChar);
            } else if (currentChar == '#') {
                plaintext.append(' ');  
            } else {
                plaintext.append(currentChar);
            }
        }

        return plaintext.toString();
    }
}