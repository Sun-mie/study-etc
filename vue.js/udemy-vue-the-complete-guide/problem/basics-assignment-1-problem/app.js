const app = Vue.createApp({
    data(){
        return{
            name:'sun-mi',
            age : 31,
            url : 'https://images.ctfassets.net/4f3rgqwzdznj/KwBiwCex2h7pTXtFhl7T8/5d7b08142e1fdd2d08ac8ea3d668b646/puppy_going_to_bathroom_on_grass_GettyImages-994816678.jpg'
        }
    },
    methods:{
        random(){
            return Math.random();
        }
    }
})
app.mount('#assignment');