/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author root
 */
public class ServletUpload extends HttpServlet {
    public static final int TAMPON =  10240;
    //public static final String PATH_FILE_SAVE="/WEB-INF/uploadedFiles/";
    public static final  String NAME_FILE_FORM="fichier"; 
    public static final String VUE="/Rapport2.jsp";
    //ServletConfig a=null;
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String upload = this.getServletContext().getRealPath("/WEB-INF/uploadedFiles/");
        System.out.println(upload + "/");
        Part part_file =  request.getPart(NAME_FILE_FORM);        
        String file_name= getFileName(part_file);
        
        if(!file_name.isEmpty() && file_name!=null)
        {
              
            //inputStream2File(is, upload +File.separator+fileName);
            copyFile(part_file,"/"+file_name,upload);
            System.out.println(file_name);
        }
      //  request.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private static String getFileName( Part part ) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {

            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring(
                contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
      
        return null;
    }
    public boolean  copyFile (Part part,String nom, String chemin)
            throws IOException
    {
        BufferedInputStream bis = null;
        BufferedOutputStream bos =new BufferedOutputStream(new FileOutputStream(new File(chemin+nom)),TAMPON);
        try
        {
            bis =  new BufferedInputStream(part.getInputStream(),TAMPON);
            //bos  = new BufferedOutputStream(new FileOutputStream(new File(nom+chemin)),TAMPON);
            
            byte[] tampon = new byte[TAMPON];
            int longueur;
            while ( ( longueur = bis.read(tampon) ) > 0 ) {
            bos.write( tampon, 0, longueur );
            }
            return true ;
        }finally
        {
            try{
                bis.close();
                bos.close();
            }catch(IOException ex)
            {
                return false ;
            }
        }
       
    }
}
