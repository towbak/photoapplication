<%@ page contentType="text/jpeg" %>
<%
	java.io.OutputStream binaryOut = response.getOutputStream();
         String indexString = request.getParameter("photo");
         int index = (new Integer(indexString.trim())).intValue();
         photos.PhotoAlbum photo = photos.PhotoAlbum.getPhotoAlbum(session);
         byte[] bytes = photo.getPhotoData(index);
         for (int i=0; i < bytes.length; i++) {
             binaryOut.write(bytes[i]);
         }
%>