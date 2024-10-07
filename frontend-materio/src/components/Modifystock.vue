<template>

    <v-card outlined>
        <v-card-title>
            Modifystock
        </v-card-title>

        <v-card-text>
            <String label="ProductId" v-model="value.productId" :editMode="editMode"/>
            <String label="ProductName" v-model="value.productName" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="modifystock"
            >
                Modifystock
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
import String from './primitives/String.vue'
import String from './String.vue'

export default {
    name: 'ModifystockCommand',
    components:{
        String,
        String,
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.productId = '';
        this.value.productName = '';
    },
    watch: {
    },
    methods: {
        modifystock() {
            this.$emit('modifystock', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>

