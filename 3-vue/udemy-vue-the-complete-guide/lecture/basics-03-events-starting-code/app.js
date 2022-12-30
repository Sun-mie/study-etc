const app = Vue.createApp({
  data() {
    return {
      counter: 10,
      name:'',
      confirmdName:'',
      enteredName: ''
    }
  },
  methods:{
    add(num){
      this.counter = this.counter + num;
    },
    reduce(num){
      this.counter = this.counter - num;
    },
    setName(event, lastName){
      // 이벤트가 발생한 요소에 엑세스
      // this.name = event.target.value;
      // 두개 이상의 인자를 받아 처리하는 경우 vue에 내장된 $event를 사용할 수 있다.
      this.name = event.target.value + ' ' + lastName;
    },
  submitForm(){
    alert('Submitted');
  },
  confirmInput(){
    this.confirmdName = this.name
  }
  }
});

app.mount('#events');
