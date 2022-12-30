const app = Vue.createApp({
  data() {
    return {
      counter: 0,
      name: '',
      lastName : '',
      // fullname: ''
    };
  },
  methods: { 
    //methods와 computed의 차이점 : methods에서 실행된 메소드는 HTML에 모든 메소드를 재실행 시킨다
    //computed는 의존성 데이터가 변경될때만 실행됨.
    //페이지에서 어떤 항목이 변경되든 값을 재계산하려는 경우 or 이벤트를 발생시켜서 값을 변경하는 경우 methods를 사용
    outputFullname(){
      console.log('Running again...')
      if(this.name === ''){
        return '';
      }else{
        return this.name + ' ' + 'jo';
      }
    },
    setName(event) {
      this.name = event.target.value;
    },
    add(num) {
      this.counter = this.counter + num;
    },
    reduce(num) {
      this.counter = this.counter - num;
      // this.counter--;
    },
    resetInput(){
      this.name='';
      this.lastName='';
    }
  },
  //computed는 주요 옵션 중 하나로 아무 자리에 올 수 있다.
  //computed는 methods와 다른 방식으로 호출되는데 기술적으론 메서드지만 data property처럼 사용된다.
  computed: {
    fullname(){
      //computed에서 의존성 값이 변경될 때만 Running again을 표시함 여기서는 this.name이 의존성.
      console.log('Running again...')
      if(this.name === '' || this.lastName === ''){
        return '';
      }else{
        return this.name + ' ' + this.lastName;
      }
    }
  },
  watch:{
    //watch의 주용도는 

    // name(value){
    //   if(value === ''){
    //     this.fullname = '';
    //   }else{
    //     this.fullname = value + ' ' + this.lastName;
    //   }
    // },
    // lastName(value){
    //   if(value === ''){
    //     this.fullname = '';
    //   }else{
    //     this.fullname = this.name + ' ' + this.lastName;
    //   }
    // }

    counter(value) {
      if (value > 50){
        const that = this; //js에서 작동하는 방식으로 function 안에 this와 function 외부 this와 같은 것을 참조하지 않음
        setTimeout(function() {
          that.counter = 0;
        },2000);
      }
    }
  }
});

app.mount('#events');
