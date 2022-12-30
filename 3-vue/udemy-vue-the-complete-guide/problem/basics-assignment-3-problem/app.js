const app = Vue.createApp({
    data(){
        return{
            number : 0
        }
    }, 
    methods :{
        addNum(value){
            this.number = this.number + value;
        }
    },
    computed : {
        result(){
            if(this.number <= 37){
                return 'Not there yet';
            }else{
                return 'Too much!';
            }
        }
    },
    watch:{
        result(){
            const that = this;
            if(that.number > 37)
            setTimeout(() => {that.number = 0}, 5000);
        }
    }


})
app.mount('#assignment');