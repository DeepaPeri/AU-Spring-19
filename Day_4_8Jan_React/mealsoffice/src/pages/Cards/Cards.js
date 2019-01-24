import React from 'react';
import PropTypes from 'prop-types';
import { withStyles, MuiThemeProvider } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import { CardImg, CardText, CardBody, CardLink,
    CardTitle, CardSubtitle, CardGroup } from 'reactstrap';

const styles = themes => ({
  card1: {
    maxWidth: 700,
    marginLeft: '10%',
  },
  card2: {
    maxWidth: 700,
	marginLeft: '10%',
	marginTop:themes.spacing.unit*10,
	
  },
  media: {
    height: 140,
    
  },
});

function MediaCard(props) {
  const { classes } = props;
  return (

	<CardGroup>
	
    <Card className={classes.card1}>
      <CardActionArea>
        <CardMedia
          className={classes.media}
          image="/static/images/cards/contemplative-reptile.jpg"
          title="Contemplative Reptile"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            Curries
          </Typography>
          <Typography component="p">
            Curries
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
        <Button OnClick = " window.location.href='http://localhost:3000/curries"size="small" color="primary">
          Share
        </Button>
        <Button size="small" color="primary">
          Learn More
        </Button>
        
      </CardActions>
    </Card>
	
	
	
	<Card className={classes.card2}>
	<CardActionArea>
	  <CardMedia
		className={classes.media}
		image="/static/images/cards/contemplative-reptile.jpg"
		title="Contemplative Reptile"
	  />
	  <CardContent>
		<Typography gutterBottom variant="h5" component="h2">
		  Fries
		</Typography>
		<Typography component="p">
		  Fries
		</Typography>
	  </CardContent>
	</CardActionArea>
	<CardActions>
	  <Button size="small" color="primary">
		Share
	  </Button>
	  <Button size="small" color="primary">
		Learn More
	  </Button>
	</CardActions>
  </Card>
</CardGroup>

  );
}

MediaCard.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(MediaCard);
