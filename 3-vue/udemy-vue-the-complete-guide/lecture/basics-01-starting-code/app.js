const app = Vue.createApp({
    //data, mothods등을 option이라 부름
    // 원래 data:Function(){} 형태지만 아래처럼 사용 가능
    // 객체를 반환
    data() {
        return {
            //숫자, 배열, 객체 등 자유롭게 사용 가능한 유연함이 있음.
            courseGoalA:'Finish the course and learn Vue!',
            courseGoalB: '<h2>Master Vue and build amazing apps!</h2>',
            vueLink : 'https://vuejs.org/'
        };
    },
    methods:{
        outputGoal(){
            const randomNumber = Math.random();
            if(randomNumber < 0.5){
                return this.courseGoalA;
            }else{
                return this.courseGoalB;
            }
        }
    }
});
//Vue와 id="user-goal"를 연결
app.mount('#user-goal'); 