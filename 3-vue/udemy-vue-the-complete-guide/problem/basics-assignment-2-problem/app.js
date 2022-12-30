const app = Vue.createApp({
    data(){
        return{
            firstText:'',
            firstOutPut: '',
            secondText:'',
            secondOutPut:''
        }
    },
    methods:{
        showAlert(){
            alert('Hi!');
        },
        keydownText(event){
            this.firstText = event.target.value;
        },
        downOutPut(){
            this.firstOutPut = this.firstText;
        },
        enterText(event){
            this.secondText = event.target.value;
        },
        enterOutPut(){
            this.secondOutPut = this.secondText;
        }


    }
});
app.mount('#assignment');