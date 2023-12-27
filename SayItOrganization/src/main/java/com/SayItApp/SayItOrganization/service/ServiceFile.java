package com.SayItApp.SayItOrganization.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.SayItApp.SayItOrganization.Models.Antaret;
import com.SayItApp.SayItOrganization.Models.ImageData;
import com.SayItApp.SayItOrganization.Models.Njoftimet;
import com.SayItApp.SayItOrganization.Models.NjoftimetDataTransfer;
import com.SayItApp.SayItOrganization.Models.Pjesmarresit;
import com.SayItApp.SayItOrganization.Models.Postimet;
import com.SayItApp.SayItOrganization.Models.PostimetMedia;
import com.SayItApp.SayItOrganization.Models.Video;
import com.SayItApp.SayItOrganization.Repository.AntaretRepro;
import com.SayItApp.SayItOrganization.Repository.ImageDataRepro;
import com.SayItApp.SayItOrganization.Repository.NjoftimetReprository;
import com.SayItApp.SayItOrganization.Repository.PjesemarresitRepro;
import com.SayItApp.SayItOrganization.Repository.PostimetMediaRepro;
import com.SayItApp.SayItOrganization.Repository.PostimetRepro;
import com.SayItApp.SayItOrganization.Repository.VideoRep;

import net.coobird.thumbnailator.Thumbnails;



@Service
public class ServiceFile {
    @Autowired
    private NjoftimetReprository njoftimetReprository;

    @Autowired
    private ImageDataRepro imageDataRepro;

    @Autowired
    private PjesemarresitRepro pjesemarresitRepro;

    @Autowired
    private AntaretRepro antaretRepro;

    @Autowired 
    private PostimetRepro postimetRepro;

    @Autowired
    private PostimetMediaRepro postimetMediaRepro;

    @Autowired
    private VideoRep videoRep;

    public   ResponseEntity<?> postoNjoftimet(NjoftimetDataTransfer data){
        try{
      
        return ResponseEntity.ok().body("ddd");
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.toString());

        }

    }
    public ResponseEntity<?> test( MultipartFile file,  String tipi, String  titulli ,  String data, String ora,  String vendi,  String pershkrimi,  String aktiv, Integer number){
        try {
          if(number<=0){
            number=1;
          }

            byte[] compressedImageData =  compressImage(file.getBytes());

            ImageData img = ImageData.builder()
            .name(file.getOriginalFilename())
            .type(file.getContentType())
            .imageData(file.getBytes())
            .build();
            imageDataRepro.save(img);
       Njoftimet njoftimet = new Njoftimet(null, img,tipi,titulli, data,ora, vendi, pershkrimi, aktiv );
       njoftimetReprository.save(njoftimet);
             List<Njoftimet> response = new ArrayList<>();
            List<Njoftimet> allData =  njoftimetReprository.findAll();
         

            if(allData.size()>(number-1)*3){
                  for(int i = (number-1)*3; i<number*3;i++){
                    if(allData.size()>i){
response.add(allData.get(i));
                    }
                
            }
            }
return ResponseEntity.ok().body(response);
        } catch (IOException e) {
            // TODO Auto-generated catch block
           return   ResponseEntity.badRequest().body(e.toString());
        }

   
    }

    public ResponseEntity<?> postoPostime(String titulli, String tipi, String data1, MultipartFile photo1, MultipartFile photo2,MultipartFile photo3, MultipartFile photo4, MultipartFile photo5, MultipartFile photo6, MultipartFile photo7, MultipartFile photo8, MultipartFile video, String pershkrimi, Integer number){
        try{
            if(number<=0){
            number=1;
          }

byte[] photo1compressed = compressImage(photo1.getBytes());
  PostimetMedia img1 = PostimetMedia.builder()
            .name(photo1.getOriginalFilename())
            .type(photo1.getContentType())
            .imageData(photo1.getBytes())
            .build();

            byte[] photo2compressed = compressImage(photo2.getBytes());
  PostimetMedia img2 = PostimetMedia.builder()
            .name(photo2.getOriginalFilename())
            .type(photo2.getContentType())
            .imageData(photo2.getBytes())
            .build();

 byte[] photo3compressed = compressImage(photo3.getBytes());
  PostimetMedia img3 = PostimetMedia.builder()
            .name(photo3.getOriginalFilename())
            .type(photo3.getContentType())
            .imageData(photo3.getBytes())
            .build();

             byte[] photo4compressed = compressImage(photo4.getBytes());
  PostimetMedia img4 = PostimetMedia.builder()
            .name(photo4.getOriginalFilename())
            .type(photo4.getContentType())
            .imageData(photo4.getBytes())
            .build();
             byte[] photo5compressed = compressImage(photo5.getBytes());
  PostimetMedia img5 = PostimetMedia.builder()
            .name(photo5.getOriginalFilename())
            .type(photo5.getContentType())
            .imageData(photo5.getBytes())
            .build();
             byte[] photo6compressed = compressImage(photo6.getBytes());
  PostimetMedia img6 = PostimetMedia.builder()
            .name(photo6.getOriginalFilename())
            .type(photo6.getContentType())
            .imageData(photo6.getBytes())
            .build();
            
            byte[] photo7compressed = compressImage(photo7.getBytes());
  PostimetMedia img7 = PostimetMedia.builder()
            .name(photo7.getOriginalFilename())
            .type(photo7.getContentType())
            .imageData(photo7.getBytes())
            .build();

               byte[] photo8compressed = compressImage(photo8.getBytes());
  PostimetMedia img8 = PostimetMedia.builder()
            .name(photo8.getOriginalFilename())
            .type(photo8.getContentType())
            .imageData(photo8.getBytes())
            .build();

          
            if(video!=null){
  Video vid = new Video();
            vid.setData(video.getBytes());
            vid.setName(video.getOriginalFilename());
            vid.setType(video.getContentType());

    postimetMediaRepro.save(img1);
      postimetMediaRepro.save(img2);
        postimetMediaRepro.save(img3);
          postimetMediaRepro.save(img4);
            postimetMediaRepro.save(img5);
              postimetMediaRepro.save(img6);
                postimetMediaRepro.save(img7);
                  postimetMediaRepro.save(img8);
                 videoRep.save(vid);
Postimet postimetsave  = new Postimet(null, titulli, tipi, data1, img1, img2, img3, img4, img5, img6, img7, img8, vid, pershkrimi);
postimetRepro.save(postimetsave);

            }else{
    postimetMediaRepro.save(img1);
      postimetMediaRepro.save(img2);
        postimetMediaRepro.save(img3);
          postimetMediaRepro.save(img4);
            postimetMediaRepro.save(img5);
              postimetMediaRepro.save(img6);
                postimetMediaRepro.save(img7);
                  postimetMediaRepro.save(img8);

                  Postimet postimetsave  = new Postimet(null, titulli, tipi, data1, img1, img2, img3, img4, img5, img6, img7, img8, null, pershkrimi);
postimetRepro.save(postimetsave);

            }
           
            List<Postimet> alldata = new ArrayList<>();
          
 List<Postimet> alldata1 = postimetRepro.findAll();
   if(alldata1.size()>(number-1)*6){
                  for(int i = (number-1)*6; i<number*6;i++){
                    if(alldata1.size()>i){
alldata.add(alldata1.get(i));
                    }
                
            }
            }



            List<Postimet> group1 = new ArrayList<>();
              List<Postimet> group2 = new ArrayList<>();
            for(int i   = 0; i<3; i++){
                if(alldata.size()>i){
 group1.add(alldata.get(i));
                }
               
            }
            for(int j = 3; j<6;j++){
                if(alldata.size()>j){
 group2.add(alldata.get(j));
                }
               
            }
          List<List> resp = new ArrayList<>();
          resp.add(group1);
          resp.add(group2);
          
            return ResponseEntity.ok().body(resp);


        }catch(Exception e){
                       return   ResponseEntity.badRequest().body(e.toString());

        }
    }
    private byte[] compressImage(byte[] imageData) throws IOException {
        // Compress the image to a specific size
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Thumbnails.of(new ByteArrayInputStream(imageData))
                .size(1000, 1000) // Set your desired width and height
                .outputQuality(1.0) // Set the desired output quality (0.0 to 1.0)
                .toOutputStream(outputStream);
        
        return outputStream.toByteArray();
    }
    

    public ResponseEntity<?> getImage(Integer number) {
    
       
  try{
        if(number<=0){
            number=1;
          }
              List<Njoftimet> response = new ArrayList<>();
            List<Njoftimet> allData =  njoftimetReprository.findAll();
         

            if(allData.size()>(number-1)*3){
                  for(int i = (number-1)*3; i<number*3;i++){
                    if(allData.size()>i){
response.add(allData.get(i));
                    }
                
            }
            }
return ResponseEntity.ok().body(response);
        
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.toString());
        }
     
    }
    public ResponseEntity<?> deteleNjoftime(Integer  id, Integer number){
try{
    if(number<=0){
            number=1;
          }
    Long id2 =  id.longValue();
    List<Pjesmarresit> pjesmarr  = pjesemarresitRepro.findByNjoftimetId(id2);
    for(int i =0; i<pjesmarr.size();i++){
      pjesemarresitRepro.deleteById(pjesmarr.get(i).getId());
    }
njoftimetReprository.deleteById(id2);
     List<Njoftimet> response = new ArrayList<>();
            List<Njoftimet> allData =  njoftimetReprository.findAll();
         

            if(allData.size()>(number-1)*3){
                  for(int i = (number-1)*3; i<number*3;i++){
                    if(allData.size()>i){
response.add(allData.get(i));
                    }
                
            }
            }
return ResponseEntity.ok().body(response);
}catch(Exception e){
    return ResponseEntity.badRequest().body(e.toString());
}
    }


    public ResponseEntity<?> updateNjoftime( Njoftimet njoftime, Integer number){
try{
    if(number<=0){
            number=1;
          }
    Optional<Njoftimet> njoftim =  njoftimetReprository.findById(njoftime.getId());
    Njoftimet njoftim2 =  njoftim.get();
    njoftim2.setData(njoftime.getData());
    njoftim2.setOra(njoftime.getOra());
    njoftim2.setPershkrimi(njoftime.getPershkrimi());
    njoftim2.setTipi(njoftime.getTipi());
    njoftim2.setTitulli(njoftime.getTitulli());
    njoftim2.setVendi(njoftime.getVendi());
    njoftimetReprository.save(njoftim2); 
     List<Njoftimet> response = new ArrayList<>();
            List<Njoftimet> allData =  njoftimetReprository.findAll();
         

            if(allData.size()>(number-1)*3){
                  for(int i = (number-1)*3; i<number*3;i++){
                    if(allData.size()>i){
response.add(allData.get(i));
                    }
                
            }
            }
return ResponseEntity.ok().body(response);
 

}catch(Exception e){
    return ResponseEntity.badRequest().body(e.toString());
}

      
    }
    public ResponseEntity<?> addAntaretFromVisitors(Antaret pjesmarresit){
        try{
            antaretRepro.save(pjesmarresit);
            return ResponseEntity.ok().body(antaretRepro.findAll());

        }catch(Exception e){
         return ResponseEntity.badRequest().body(e.toString());

        }
    }
    public ResponseEntity<?> getAntaret(){
        try{
            return ResponseEntity.ok().body(antaretRepro.findAll());
        }catch(Exception e){
              return ResponseEntity.badRequest().body(e.toString());
        }

    }

    public ResponseEntity<?> deleteAntaret(Integer id){
        try{
            Long id1 = id.longValue();
            antaretRepro.deleteById(id1);
               return ResponseEntity.ok().body(antaretRepro.findAll());

        }catch(Exception e){
                          return ResponseEntity.badRequest().body(e.toString());

        }

    }
    public ResponseEntity<?> updateAntaret(Antaret body){
        try{
antaretRepro.save(body);
 return ResponseEntity.ok().body(antaretRepro.findAll());


        }catch(Exception e){
                                      return ResponseEntity.badRequest().body(e.toString());

        }
    }
    public ResponseEntity<?> getPostimet(Integer number){
        try{
           if(number<=0){
            number=1;
          }
                List<Postimet> alldata = new ArrayList<>();
           
 List<Postimet> alldata1 = postimetRepro.findAll();
   if(alldata1.size()>(number-1)*6){
                  for(int i = (number-1)*6; i<number*6;i++){
                    if(alldata1.size()>i){
alldata.add(alldata1.get(i));
                    }
                
            }
            }
          
            List<Postimet> group1 = new ArrayList<>();
              List<Postimet> group2 = new ArrayList<>();
            for(int i   = 0; i<3; i++){
                if(alldata.size()>i){
 group1.add(alldata.get(i));
                }
               
            }
            for(int j = 3; j<6;j++){
                if(alldata.size()>j){
 group2.add(alldata.get(j));
                }
               
            }
          List<List> resp = new ArrayList<>();
          resp.add(group1);
          resp.add(group2);
          
            return ResponseEntity.ok().body(resp);
        }catch(Exception e){
                                      return ResponseEntity.badRequest().body(e.toString());

        }
    }
    public ResponseEntity<?> updatePostime(Postimet file, Integer number){
        try{
           if(number<=0){
            number=1;
          }
postimetMediaRepro.save(file.getPhoto1());
postimetMediaRepro.save(file.getPhoto2());
postimetMediaRepro.save(file.getPhoto3());
postimetMediaRepro.save(file.getPhoto4());
postimetMediaRepro.save(file.getPhoto5());
postimetMediaRepro.save(file.getPhoto6());
postimetMediaRepro.save(file.getPhoto7());
postimetMediaRepro.save(file.getPhoto8());
if(file.getVideo()!=null){
videoRep.save(file.getVideo());
}

postimetRepro.save(file);

    List<Postimet> alldata = new ArrayList<>();
           
 List<Postimet> alldata1 = postimetRepro.findAll();
   if(alldata1.size()>(number-1)*6){
                  for(int i = (number-1)*6; i<number*6;i++){
                    if(alldata1.size()>i){
alldata.add(alldata1.get(i));
                    }
                
            }
            }
          
            List<Postimet> group1 = new ArrayList<>();
              List<Postimet> group2 = new ArrayList<>();
            for(int i   = 0; i<3; i++){
                if(alldata.size()>i){
 group1.add(alldata.get(i));
                }
               
            }
            for(int j = 3; j<6;j++){
                if(alldata.size()>j){
 group2.add(alldata.get(j));
                }
               
            }
          List<List> resp = new ArrayList<>();
          resp.add(group1);
          resp.add(group2);
          
            return ResponseEntity.ok().body(resp);

        }catch(Exception e){
                                                  return ResponseEntity.badRequest().body(e.toString());

        }
    }
    public ResponseEntity<?> deletePostimet(Integer id, Integer number){
        try{
 if(number<=0){
            number=1;
          }
            Optional<Postimet> postim = postimetRepro.findById(id.longValue());
            Postimet post =  postim.get();
            postimetRepro.delete(post);
            postimetMediaRepro.delete(post.getPhoto1());
 postimetMediaRepro.delete(post.getPhoto2());

   postimetMediaRepro.delete(post.getPhoto3());
 postimetMediaRepro.delete(post.getPhoto4());

   postimetMediaRepro.delete(post.getPhoto5());
 postimetMediaRepro.delete(post.getPhoto6());

   postimetMediaRepro.delete(post.getPhoto7());
 postimetMediaRepro.delete(post.getPhoto8());
 if(post.getVideo()!=null){
    videoRep.delete(post.getVideo());
 }


    List<Postimet> alldata = new ArrayList<>();
           
 List<Postimet> alldata1 = postimetRepro.findAll();
   if(alldata1.size()>(number-1)*6){
                  for(int i = (number-1)*6; i<number*6;i++){
                    if(alldata1.size()>i){
alldata.add(alldata1.get(i));
                    }
                
            }
            }
          
            List<Postimet> group1 = new ArrayList<>();
              List<Postimet> group2 = new ArrayList<>();
            for(int i   = 0; i<3; i++){
                if(alldata.size()>i){
 group1.add(alldata.get(i));
                }
               
            }
            for(int j = 3; j<6;j++){
                if(alldata.size()>j){
 group2.add(alldata.get(j));
                }
               
            }
          List<List> resp = new ArrayList<>();
          resp.add(group1);
          resp.add(group2);
          
            return ResponseEntity.ok().body(resp);

        }catch(Exception e){

                                                  return ResponseEntity.badRequest().body(e.toString());

        }
    }public ResponseEntity<?> getNJoftimetVisitorDesktop(Integer number){
      try{
         if(number<=0){
            number=1;
          }
                 List<Njoftimet> response = new ArrayList<>();
            List<Njoftimet> allData =  njoftimetReprository.findAll();
         List<List> responseBig = new ArrayList();

            if(allData.size()>(number-1)*6){
                  for(int i = (number-1)*6; i<number*6;i++){
                    if(allData.size()>i){
response.add(allData.get(i));
                    }
                
            }
            }
                 List<Njoftimet> group1 = new ArrayList<>();
              List<Njoftimet> group2 = new ArrayList<>();

  for(int i   = 0; i<3; i++){
                if(response.size()>i){
 group1.add(response.get(i));
                }
               
            }
            for(int j = 3; j<6;j++){
                if(response.size()>j){
 group2.add(response.get(j));
                }
               
            }




            List<Integer> PagesResponse =  new ArrayList<>();
            Integer allpages =  allData.size()/6+1;
if(allpages==1){
PagesResponse.add(1);
}else if (allpages==2){
  PagesResponse.add(1);
  PagesResponse.add(2);
} else if (allpages==3){
   PagesResponse.add(1);
  PagesResponse.add(2);
   PagesResponse.add(3);
}else if(allpages>3){
  if(number<=allpages){
  if(number==allpages){
     PagesResponse.add(number-2);
  PagesResponse.add(number-1);
   PagesResponse.add(number);
  }else if(number==1){
     PagesResponse.add(1);
  PagesResponse.add(2);
   PagesResponse.add(3);
   } else{
         PagesResponse.add(number-1);
  PagesResponse.add(number);
   PagesResponse.add(number+1);
  }

  }



}

responseBig.add(group1);
responseBig.add(group2);

responseBig.add(PagesResponse);
responseBig.add(response);



            return ResponseEntity.ok().body(responseBig);

      }catch(Exception e){
                                                          return ResponseEntity.badRequest().body(e.toString());

      }
    }
public ResponseEntity<?> RegisterPjestar(Pjesmarresit pjesmarresit){
  try{
  njoftimetReprository.save(pjesmarresit.getNjoftimet());
  imageDataRepro.save(pjesmarresit.getNjoftimet().getPhoto());
pjesemarresitRepro.save(pjesmarresit);
            return ResponseEntity.ok().body(pjesmarresit);

  }catch(Exception e){
                                                              return ResponseEntity.badRequest().body(e.toString());

  }

}
public ResponseEntity<?> getPjesmarresit(Long id){
  try{
List<Pjesmarresit> pjesmarresit  =  pjesemarresitRepro.findByNjoftimetId(id);
            return ResponseEntity.ok().body(pjesmarresit);

  }catch(Exception e){
                                                              return ResponseEntity.badRequest().body(e.toString());

  }

}
public ResponseEntity<?> postoPjesmmarres(Long id, Pjesmarresit pjesmarresit){
  try{
    Optional<Njoftimet> njoftim1 = njoftimetReprository.findById(id);
Njoftimet njoftimet = njoftim1.get();
pjesmarresit.setNjoftimet(njoftimet);
pjesemarresitRepro.save(pjesmarresit);

List<Pjesmarresit> pjesmarresit1  =  pjesemarresitRepro.findByNjoftimetId(id);
            return ResponseEntity.ok().body(pjesmarresit1);



  }catch(Exception e){
                return ResponseEntity.ok().body(pjesmarresit);

  }
}
    public ResponseEntity<?> updatePjestaret(Pjesmarresit pjesmarresit, Long id ){
  try{
Optional<Pjesmarresit> pjesmarresit1 = pjesemarresitRepro.findById(pjesmarresit.getId());
Pjesmarresit pjesmarresit2 =  pjesmarresit1.get();
pjesmarresit2.setArsimi(pjesmarresit.getArsimi());
pjesmarresit2.setDoethemi(pjesmarresit.getDoethemi());
pjesmarresit2.setEmail(pjesmarresit.getEmail());
pjesmarresit2.setEmri(pjesmarresit.getEmri());
pjesmarresit2.setInstitucioni(pjesmarresit.getInstitucioni());
pjesmarresit2.setMosha(pjesmarresit.getMosha());
pjesmarresit2.setNjoftimet(pjesmarresit.getNjoftimet());
pjesmarresit2.setNumri(pjesmarresit.getNumri());
pjesmarresit2.setVendbanim(pjesmarresit.getVendbanim());

List<Pjesmarresit> pjesmarresit3  =  pjesemarresitRepro.findByNjoftimetId(id);
            return ResponseEntity.ok().body(pjesmarresit3);



  }catch(Exception e){
                return ResponseEntity.ok().body(e.toString());

  }
}public ResponseEntity<?> deletePjesmarresit(Long id){
  try{
Optional<Pjesmarresit> pjesmarr = pjesemarresitRepro.findById(id);
  Pjesmarresit pjessmarr2 = pjesmarr.get();

Long njoftimid = pjessmarr2.getNjoftimet().getId();
pjesemarresitRepro.deleteById(id);
  return ResponseEntity.ok().body(pjesemarresitRepro.findByNjoftimetId(njoftimid));

  }catch(Exception e){
                    return ResponseEntity.ok().body(e.toString());

  }

}public ResponseEntity<?> GetPostimetVisitor(Integer number){
try{
   if(number<=0){
            number=1;
          }
List<Postimet> trepostime = new ArrayList<>();
                 List<Postimet> response = new ArrayList<>();
            List<Postimet> allData =  postimetRepro.findAll();
            if(allData.size()>=3){
              trepostime.add(allData.get(allData.size()-1));
               trepostime.add(allData.get(allData.size()-2));
                trepostime.add(allData.get(allData.size()-3));
                allData.remove(allData.size()-1);
                  allData.remove(allData.size()-1);
                    allData.remove(allData.size()-1);
            }
         List<List> responseBig = new ArrayList();
Collections.reverse(allData);
            if(allData.size()>(number-1)*6){
                  for(int i = (number-1)*6; i<number*6;i++){
                    if(allData.size()>i){
response.add(allData.get(i));
                    }
                
            }
            }
                 List<Postimet> group1 = new ArrayList<>();
              List<Postimet> group2 = new ArrayList<>();

  for(int i   = 0; i<3; i++){
                if(response.size()>i){
 group1.add(response.get(i));
                }
               
            }
            for(int j = 3; j<6;j++){
                if(response.size()>j){
 group2.add(response.get(j));
                }
               
            }




            List<Integer> PagesResponse =  new ArrayList<>();
            Integer allpages =  allData.size()/6+1;
if(allpages==1){
PagesResponse.add(1);
}else if (allpages==2){
  PagesResponse.add(1);
  PagesResponse.add(2);
} else if (allpages==3){
   PagesResponse.add(1);
  PagesResponse.add(2);
   PagesResponse.add(3);
}else if(allpages>3){
  if(number<=allpages){
  if(number==allpages){
     PagesResponse.add(number-2);
  PagesResponse.add(number-1);
   PagesResponse.add(number);
  }else if(number==1){
     PagesResponse.add(1);
  PagesResponse.add(2);
   PagesResponse.add(3);
   } else{
         PagesResponse.add(number-1);
  PagesResponse.add(number);
   PagesResponse.add(number+1);
  }

  }



}
responseBig.add(trepostime);
responseBig.add(group1);
responseBig.add(group2);




responseBig.add(PagesResponse);

            return ResponseEntity.ok().body(responseBig);

}catch(Exception e){
                return ResponseEntity.ok().body(e.toString());

}
}

public ResponseEntity<?> GetPostim(  Long id ){
  try{
 return ResponseEntity.ok().body(postimetRepro.findById(id));
  }catch(Exception e){
                                  return ResponseEntity.ok().body(e.toString());

  }
}

public ResponseEntity<?> GetPostimMobile(Integer number){
try{
   if(number<=0){
            number=1;
          }

                 List<Postimet> response = new ArrayList<>();
            List<Postimet> allData =  postimetRepro.findAll();
        
         List<List> responseBig = new ArrayList();

            if(allData.size()>(number-1)*6){
                  for(int i = (number-1)*6; i<number*6;i++){
                    if(allData.size()>i){
response.add(allData.get(i));
                    }
                
            }
            }
               


            List<Integer> PagesResponse =  new ArrayList<>();
            Integer allpages =  allData.size()/6+1;
if(allpages==1){
PagesResponse.add(1);
}else if (allpages==2){
  PagesResponse.add(1);
  PagesResponse.add(2);
} else if (allpages==3){
   PagesResponse.add(1);
  PagesResponse.add(2);
   PagesResponse.add(3);
}else if(allpages>3){
  if(number<=allpages){
  if(number==allpages){
     PagesResponse.add(number-2);
  PagesResponse.add(number-1);
   PagesResponse.add(number);
  }else if(number==1){
     PagesResponse.add(1);
  PagesResponse.add(2);
   PagesResponse.add(3);
   } else{
         PagesResponse.add(number-1);
  PagesResponse.add(number);
   PagesResponse.add(number+1);
  }

  }



}
Collections.reverse(response);
responseBig.add(response);




responseBig.add(PagesResponse);

            return ResponseEntity.ok().body(responseBig);

}catch(Exception e){
                return ResponseEntity.ok().body(e.toString());

}
}
}
