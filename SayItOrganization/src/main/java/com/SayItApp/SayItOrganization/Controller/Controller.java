package com.SayItApp.SayItOrganization.Controller;

import javax.annotation.security.RolesAllowed;
import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.SayItApp.SayItOrganization.Models.Antaret;
import com.SayItApp.SayItOrganization.Models.AuthCredentialsRequest;
import com.SayItApp.SayItOrganization.Models.ImageData;
import com.SayItApp.SayItOrganization.Models.Njoftimet;
import com.SayItApp.SayItOrganization.Models.NjoftimetDataTransfer;
import com.SayItApp.SayItOrganization.Models.Pjesmarresit;
import com.SayItApp.SayItOrganization.Models.Postimet;
import com.SayItApp.SayItOrganization.Models.TestData;
import com.SayItApp.SayItOrganization.Models.User;
import com.SayItApp.SayItOrganization.service.ServiceFile;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping("/api/test")

public class Controller {
    private static final String SECRET_KEY = "ggygfiodfewfwefvgewcddsdewc";
    @Autowired
    private ServiceFile serviceFile;



    @GetMapping("posttest")
    public Claims fucntion(){
         return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6OTIyMzM3MjAzNjg1NDc3NSwiaWF0IjoxNzAxMjczMTc1fQ.mS0Y_B02I6OPwWkpsbjkN7gy_bZRbHhLnk0fEUF1MyuYJzfq-z6yiwW_DWaxBOL3kmC3foo8ybj43kHNhNFnwg ").getBody();
       
    }
    @GetMapping("verifyrole")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public ResponseEntity<String> verifyRoles(){
return ResponseEntity.ok().body("ok");
   }
   @PostMapping("postonjoftime1/{page}")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
 public ResponseEntity<?> postoNjoftimet( @PathVariable Integer page, @RequestParam("photo") MultipartFile file, @RequestParam("tipi") String tipi,@RequestParam("titulli") String  titulli , @RequestParam("data") String data, @RequestParam("ora") String ora, @RequestParam("vendi") String vendi, @RequestParam("pershkrimi") String pershkrimi, @RequestParam("aktiv") String aktiv){


   try{
    //return ResponseEntity.ok().body("done");
 
return ResponseEntity.ok().body(serviceFile.test( file,  tipi, titulli ,  data,  ora,   vendi,  pershkrimi,   aktiv, page));
   }catch(Exception e){
      return ResponseEntity.ok().body(e.toString());
   }

 }

 @PostMapping("postoPostime/{page}")
 @PreAuthorize("hasAuthority('ROLE_ADMIN')")
 public ResponseEntity<?> postoPostime(@RequestParam("titulli") String titulli, @RequestParam("tipi") String tipi, @RequestParam("data") String data, @RequestParam("photo1") MultipartFile photo1, @RequestParam("photo2") MultipartFile photo2,@RequestParam("photo3") MultipartFile photo3,@RequestParam("photo4") MultipartFile photo4,@RequestParam("photo5") MultipartFile photo5,@RequestParam("photo6") MultipartFile photo6,@RequestParam("photo7") MultipartFile photo7,@RequestParam("photo8") MultipartFile photo8, @RequestParam(value = "video", required = false)  MultipartFile video, @RequestParam("pershkrimi") String pershkrimi, @PathVariable Integer page){

   try{
     
return ResponseEntity.ok().body(serviceFile.postoPostime( titulli,  tipi, data,  photo1,  photo2, photo3, photo4, photo5, photo6, photo7, photo8, video, pershkrimi, page));
   }catch(Exception e){
            return ResponseEntity.ok().body(e.toString());

   }
 }

 @GetMapping("postonjoftime2")
 public ResponseEntity<?> postoNjoftimet1(){
   try{
     //@RequestBody Njoftimet data
return   ResponseEntity.ok().body("wwwwww"); ///serviceFile.postoNjoftimet(data);
   }catch(Exception e){
      return ResponseEntity.ok().body(e.toString());
   }

 }
   @GetMapping("getNjoftimet/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> getImage(@PathVariable Integer id) {
      try{
     
return serviceFile.getImage(id);
      }catch(Exception e){
return ResponseEntity.ok().body(e.toString());

      }
      
    }
    @DeleteMapping("deletenjoftime/{id1}/{id}")
     @PreAuthorize("hasAuthority('ROLE_ADMIN')")
     public ResponseEntity<?> deleteNjoftime(@PathVariable  Integer id1,@PathVariable Integer id){
      try{
return ResponseEntity.ok().body(serviceFile.deteleNjoftime(id, id1)) ;
      }catch(Exception e){
       return   ResponseEntity.badRequest().body(e.toString());
      }
    
     }
   @PutMapping("updateNjoftime/{id}")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public ResponseEntity<?> updateNjoftime(@RequestBody Njoftimet njoftime,  @PathVariable Integer id){
try{
   return ResponseEntity.ok().body(serviceFile.updateNjoftime(njoftime, id));
 
}catch(Exception e){
   return ResponseEntity.badRequest().body(e.toString());
}


   }
   @PostMapping("addAntaretFromVisitors")
   @PreAuthorize("hasAuthority('ROLE_VISITOR')")
      public ResponseEntity<?> addAntaretFromVisitors(@RequestBody Antaret antaret){
try{
  return ResponseEntity.ok().body(serviceFile.addAntaretFromVisitors(antaret));
 
}catch(Exception e){
   return ResponseEntity.ok().body(e.toString());
}


   }
   @GetMapping("getAntaretFromAdmin")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public ResponseEntity<?> getAntaret(){
      try{
         return ResponseEntity.ok().body(serviceFile.getAntaret());
      }catch(Exception e){
           return ResponseEntity.ok().body(e.toString());
      }
   }
   @DeleteMapping("deleteArtaret/{id}")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public ResponseEntity<?> deleteAntaret(@PathVariable Integer id){
      try{
         return ResponseEntity.ok().body(serviceFile.deleteAntaret(id));
      }catch(Exception e){
           return ResponseEntity.ok().body(e.toString());
      }
   }
@PutMapping("updateAntar")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public ResponseEntity<?> updateNjoftime(@RequestBody Antaret body){
   try{
return ResponseEntity.ok().body(serviceFile.updateAntaret(body));
   }catch(Exception e){
                 return ResponseEntity.ok().body(e.toString());

   }
}

@GetMapping("getPostimet/{page}")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public ResponseEntity<?> getPostimet(@PathVariable Integer page){
   try{
return ResponseEntity.ok().body(serviceFile.getPostimet(page));

   }catch(Exception e){
                       return ResponseEntity.ok().body(e.toString());

   }
}

@PutMapping("updatepost/{page}")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public ResponseEntity<?> updatePostime(@RequestBody Postimet file, @PathVariable Integer page){
   try{

       return ResponseEntity.ok().body(serviceFile.updatePostime(file, page));
   }catch(Exception e){
                             return ResponseEntity.ok().body(e.toString());

   }
}
@DeleteMapping("deletePostimet/{id}/{page}")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public ResponseEntity<?> deletePostimet(@PathVariable Integer id, @PathVariable Integer page){

      try{

       return ResponseEntity.ok().body(serviceFile.deletePostimet(id, page));
   }catch(Exception e){
                             return ResponseEntity.ok().body(e.toString());

   }

}
@GetMapping("getNjoftimetVisitor/{page}")
@PreAuthorize("hasAuthority('ROLE_VISITOR')")
public ResponseEntity<?> getNJoftimetVisitorDesktop( @PathVariable Integer page){

      try{

       return ResponseEntity.ok().body(serviceFile.getNJoftimetVisitorDesktop( page));
   }catch(Exception e){
                             return ResponseEntity.ok().body(e.toString());

   }

}


@PostMapping("registerPjestar")
@PreAuthorize("hasAuthority('ROLE_VISITOR')")
public ResponseEntity<?> RegisterPjestar(@RequestBody Pjesmarresit pjesmarresit){
     try{

       return ResponseEntity.ok().body(serviceFile.RegisterPjestar( pjesmarresit));
   }catch(Exception e){
                             return ResponseEntity.ok().body(e.toString());

   }

}
@GetMapping("getPjesmarreitNjoftim/{id}")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public ResponseEntity<?> getPjesmarresit(@PathVariable Long id){
   try{
  return ResponseEntity.ok().body(serviceFile.getPjesmarresit(id));
   }catch(Exception e){
                                   return ResponseEntity.ok().body(e.toString());

   }
}
@PostMapping("postPjesmarresitNjoftim/{id}")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public ResponseEntity<?> postoPjesmmarres(@PathVariable Long id, @RequestBody Pjesmarresit pjesmarresit){
   try{
  return ResponseEntity.ok().body(serviceFile.postoPjesmmarres(id, pjesmarresit));
   }catch(Exception e){
                                   return ResponseEntity.ok().body(e.toString());

   }
}


@PutMapping("updatePjesmarresitNjoftim/{id}")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public ResponseEntity<?> updatePjestaret( @RequestBody Pjesmarresit pjesmarresit, @PathVariable Long id ){
   try{
  return ResponseEntity.ok().body(serviceFile.updatePjestaret( pjesmarresit, id));
   }catch(Exception e){
                                   return ResponseEntity.ok().body(e.toString());

   }
}



@DeleteMapping("deletePjesmarresit/{id}")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public ResponseEntity<?> deletePjesmarresit(  @PathVariable Long id ){
   try{
  return ResponseEntity.ok().body(serviceFile.deletePjesmarresit(id));
   }catch(Exception e){
                                   return ResponseEntity.ok().body(e.toString());

   }
}


@GetMapping("getPostimetDesktop/{page}")
@PreAuthorize("hasAuthority('ROLE_VISITOR')")
public ResponseEntity<?> GetPostimetVisitor( @PathVariable Integer page ){
   try{
  return ResponseEntity.ok().body(serviceFile.GetPostimetVisitor(page));
   }catch(Exception e){
                                   return ResponseEntity.ok().body(e.toString());

   }
}
@GetMapping("/getPostimVisitor/{id}")
@PreAuthorize("hasAuthority('ROLE_VISITOR')")
public ResponseEntity<?> GetPostim(  @PathVariable Long id ){
   try{
  return ResponseEntity.ok().body(serviceFile.GetPostim(id));
   }catch(Exception e){
                                   return ResponseEntity.ok().body(e.toString());

   }
}

@GetMapping("/getPostimetVisitorMobile/{id}")
@PreAuthorize("hasAuthority('ROLE_VISITOR')")
public ResponseEntity<?> GetPostimMobile(  @PathVariable Integer id ){
   try{
  return ResponseEntity.ok().body(serviceFile.GetPostimMobile(id));
   }catch(Exception e){
                                   return ResponseEntity.ok().body(e.toString());

   }
}
}