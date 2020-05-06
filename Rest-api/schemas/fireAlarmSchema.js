const mongoose=require('mongoose');
const Schema =mongoose.Schema;
mongoose.set('useFindAndModify', false);

const firealarmSchema=new Schema({

  floorNo:{
    type:Number,
    required:[true,"floorNo should be defined"]
  },
  roomNo:{
  type:Number,
    required:[true,"roomNo should be defined"]
  },
  smokelevel:{
  type:Number,
    required:[true,"smokelevel should be defined"]
  },
  co2_level:{
  type:Number,
    required:[true,"co2_level should be defined"]
  },
  status:{
  type:Boolean,
    default:false
  },
   co2_Alert:{
     type:Boolean,
     default:false
   },
   smoke_Alert:{
     type:Boolean,
     default:false
   }
});

const FireAlarm=mongoose.model('monitorfireAlarm',firealarmSchema);
module.exports=FireAlarm;
