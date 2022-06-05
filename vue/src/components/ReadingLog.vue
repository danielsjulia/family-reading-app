<template>
  <div>
    <table>
    <tr>
        <th>Company</th>
        <th>Contact</th>
        <th>Country</th>
    </tr>
    <tr>
        <td>Alfreds Futterkiste</td>
        <td>Maria Anders</td>
        <td>Germany</td>
    </tr>
    <tr>
        <td>Centro comercial Moctezuma</td>
        <td>Francisco Chang</td>
        <td>Mexico</td>
    </tr>
    </table>
  </div>
</template>

<script>
import readingLog from '../services/readingLog.js';

export default {
    name: 'reading-log',
    props: {
        member: Object
    },
    data() {
        return {
            readingLog: []
        }
    },
    created() {


        readingLog.getReadingLogDTOByUserId(this.member.userId)
        .then(
            response => {
                this.readingLog = response.data;
            }
        )
    }

}
</script>

<style>

</style>