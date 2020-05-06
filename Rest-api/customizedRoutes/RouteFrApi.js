const express=require('express');
const router=express.Router();
const FireAlarm=require('../schemas/firealarmSchema');


//list the all fire alarm details
router.get('/details',function(req,res,next){
  FireAlarm.find({}).then(function(item){
    res.send(item);
  })
});


//add anew  fire alarm details
 router.post('/details',function(req,res,next){
   FireAlarm.create({
     floorNo :parseFloat(req.body.floorNo),
     roomNo  :parseFloat(req.body.roomNo),
     smokelevel :parseFloat(req.body.smokelevel),
     co2_level:parseFloat(req.body.co2_level),
     status:req.body.status,
     co2_Alert:req.body.co2_Alert,
     smoke_Alert:req.body.smoke_Alert
   }
    ).then(function(item){
     res.send(item);
   }).catch(next);

});


//update a fire alarm details
router.put('/details/:id',function(req,res,next){
  FireAlarm.findByIdAndUpdate({_id:req.params.id},{
    floorNo :parseFloat(req.body.floorNo),
    roomNo  :parseFloat(req.body.roomNo),
    smokelevel :parseFloat(req.body.smokelevel),
    co2_level:parseFloat(req.body.co2_level),
    status:req.body.status,
    co2_Alert:req.body.co2_Alert,
    smoke_Alert:req.body.smoke_Alert
  }).then(function(){
             FireAlarm.findOne({_id:req.params.id}).then(function(single){
               res.send(single);

             });
          });

  });





//Search a certain record
router.get('/search/:id',function(req,res,next){

  FireAlarm.find({_id:req.params.id}).then(function(item){
    res.send(item);
  });
});

//delete a fire alarm details
router.delete('/details/:id',function(req,res,next){

  FireAlarm.findByIdAndRemove({_id:req.params.id}).then(function(item){
    res.send(item);
  });
});

module.exports=router;
