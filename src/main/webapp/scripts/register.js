

function validate(form){
    let enameErr=document.getElementById("eNameErr");
    let genderErr=document.getElementById("genderErr");
    let jobErr=document.getElementById("jobErr");
    let salErr=document.getElementById("salErr");
    let deptNoErr=document.getElementById("deptNoErr");
    enameErr.innerHTML="";
    genderErr.innerHTML="";
    jobErr.innerHTML="";
    salErr.innerHTML="";
    deptNoErr.innerHTML="";
    let validate =true;
    let ename=form.ename.value;
    let gender=form.gender.value;
    let esal=form.esal.value;
    let job=form.job.value;
    let deptNo=form.deptNo.value;
    form.vflag.value=true;
    let nameValid,genderValid,salaryValid,jobValid,deptNoValid=true;
    if(ename.length<5 || ename.length>30){
        enameErr.innerHTML="Name Should be greater than 5 characters and less than 30 characters";
        nameValid=false;

    }
    if (gender.length<=0){
        genderErr.innerHTML="Please Select Gender";
        genderValid=false;
    }
    if(job.length<5 || job.length>50){
        jobErr.innerHTML="Job Should be greater than 5 characters and less than 30 characters";
        jobValid=false;
    }

    if(isNaN(esal) || esal<200000 || esal>10000){
        salErr.innerHTML="Salary should be in range  between 10000 to 200000";
        salaryValid=false;
    }
    if(deptNo>0 || deptNo < 1000){
        deptNoErr.innerHTML="DepartmentNo Should be in range between 1 to 1000";
        deptNoValid=false;
    }


    if(!genderValid || !nameValid ||!jobValid || !salaryValid || !deptNoValid){
        return false;
    }else {
        return true;
    }





}