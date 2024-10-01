import {Routes} from '@angular/router';
import {CastVoteComponent} from "./components/cast-vote/cast-vote.component";
import {StatisticsComponent} from "./components/statistics/statistics.component";

export const routes: Routes = [
  {path: 'statistics', component: StatisticsComponent},
  {path: 'cast-vote', component: CastVoteComponent},
  {path: '', redirectTo: '/statistics', pathMatch: 'full'}
];
