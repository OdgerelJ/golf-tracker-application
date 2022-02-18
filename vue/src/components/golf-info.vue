<template>
  <div>
    <div id="golf-tracker-info">
      <section id="section-a">
        <p>
          Use Golf League Tracker for full end-to-end management of your league.
          Let Golf League Tracker calculate your handicaps, points, standings,
          and sub-requests. Spend less time managing your league, and more time
          playing golf!
        </p>
      </section>
      <section id="section-b">
        <p>
          Golf League Tracker's Handicap Manager will allow you to compute
          handicaps using the total score for the player.
        </p>
      </section>
      <section id="section-c">
        <div class="box1">
          <h4>Players </h4>
          <p> Manage up to 100 regular players and unlimited subs (double that
          amount with the Extended League Upgrade). Players can log in to see
          their results, check the schedule, see countless stats, and talk trash
          in the discussion forum.</p>
         
        </div>
        <div class="box2">
          <h4>Handicaps</h4>
          <p>Configure your settings to match what YOU need, and Golf
          League Tracker will handle the rest.</p>
        </div>
        <div class="box3">
          <h4>Points *</h4>
          <p>Set up match play, stroke play, stableford, best ball,
          high/low, and any combination to the league format you want. Check the
          settings list for full details.</p>
        </div>
      </section>
      </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>

#section-a {
  padding: 20px;
  background: #926239;
  color: #fff;
  text-align: center;
}

#section-b {
  padding: 20px;
  background: #f4f4f4;
  text-align: center;
}

#section-c {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
 
}

#section-c div {
  padding: 20px;
}

#section-c .box1 {
  background: #926239;
  color: white;
}

#section-c .box2 {
  background: #f9f9f9;
}

#section-c .box3 {
  background: #926239;
  color: white;
}

@media only screen and (max-width:600px) {
  
  #golf-tracker-info {
    display: grid;
    grid-template-columns: 1fr;
    grid-template-rows: 1fr;
  }

  #section-c {
    display: grid;
    grid-template-columns: 1fr;
    grid-template-rows: 1fr;
  }
}
</style>