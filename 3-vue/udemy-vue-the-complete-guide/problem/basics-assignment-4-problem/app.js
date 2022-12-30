const app = Vue.createApp({
    data() {
        return{
            userName : '',
            showBtn : true,
            backColor : ''
        };
    },
    computed:{
        userCheck(){
            return {
                 user1 : this.userName=='user1'
                ,user2 : this.userName=='user2' 
            }
        },
        showInline(){
            return {visible : this.showBtn, hidden : !this.showBtn}
        }
    },
    watch:{
    },
    methods: {
        changeBtn(){
            this.showBtn = !this.showBtn;
        }
    }
});

app.mount('#assignment');