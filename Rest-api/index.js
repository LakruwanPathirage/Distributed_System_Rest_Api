const express=require('express');
const fullRoutes=require('./customizedRoutes/RouteFrApi');
const  Parsbdy=require('body-parser');
const mongoose=require('mongoose');
const app=express();
const cors = require('cors');

mongoose.connect('mongodb://localhost/monitor', {useUnifiedTopology: true, useNewUrlParser: true }).then(() => console.log('MongoDB Connected...'))
    .catch(err => console.log(err));
mongoose.Promise=global.Promise;

app.use(cors());//acess controll_security feature
app.use(function (req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header('Access-Control-Allow-Methods: GET, POST, OPTIONS');
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
});


app.use(Parsbdy.json());
app.use('/monitoring',fullRoutes);

//custom error handling
app.use(function(erro,rq,res,next){
  res.status(422).send({error:erro.message});
});

app.listen(4000,function(){
  console.log('Listning the request in port 4000');
});
